package com.rg.contacts.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rg.contacts.ContactApplication
import com.rg.contacts.R
import com.rg.contacts.adapters.ContactsAdapter
import com.rg.contacts.dao.ContactDao
import com.rg.contacts.databinding.FragmentContactsBinding
import com.rg.contacts.entities.Contact
import com.rg.contacts.interfaces.ItemClick
import com.rg.contacts.repositories.ContactRepository
import com.rg.contacts.roomDB.ContactsRoomDataBase
import com.rg.contacts.viewmodels.AddContactViewModel
import com.rg.contacts.viewmodels.ContactsViewModel
import com.rg.contacts.views.AddContact

class ContactsFragment : Fragment() , ItemClick {

    private lateinit var binding: FragmentContactsBinding

    private lateinit var contactsViewModel: ContactsViewModel
    private lateinit var contactDao: ContactDao


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactsBinding.inflate(inflater, container, false)
        val contactRepository = ContactRepository(contactDao)
        val factory = ContactsViewModel.ContactsViewModelFactory(contactRepository)
        contactsViewModel = ViewModelProvider(requireActivity(), factory).get(ContactsViewModel::class.java)
        binding.viewModel = contactsViewModel
        binding.lifecycleOwner = this
//
        setClickListeners()
        setObservers()

        return binding.root


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contactDao = ContactsRoomDataBase.getDatabase(context).contactDao()

    }


    private fun setClickListeners() {
        binding.fab.setOnClickListener(View.OnClickListener {
            val addIntent = Intent(activity, AddContact::class.java)
            startActivity(addIntent)
        })
    }

    private fun setObservers() {
        contactsViewModel.allContacts.observe(this, Observer {
           setAdapter(it)
        })
    }

    private fun setAdapter( listContacts : List<Contact>) {

        val adapter = ContactsAdapter(listContacts , this);
        val linearLayoutManager = LinearLayoutManager(activity)
        binding.rvContacts.layoutManager = linearLayoutManager
        binding.rvContacts.adapter = adapter;
    }

    override fun onItemClicked(item: Any) {

        val addIntent = Intent(activity, AddContact::class.java)
        addIntent.putExtra("Item", item as Contact)
        startActivity(addIntent)

    }


}
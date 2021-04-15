package com.rg.contacts.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rg.contacts.R
import com.rg.contacts.databinding.ActivityAddContactBinding
import com.rg.contacts.entities.Contact
import com.rg.contacts.repositories.ContactRepository
import com.rg.contacts.roomDB.ContactsRoomDataBase
import com.rg.contacts.viewmodels.AddContactViewModel

class AddContact : AppCompatActivity() {
    private lateinit var binding : ActivityAddContactBinding
    private lateinit var addContactViewModel: AddContactViewModel
    private var contact : Contact ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = DataBindingUtil.setContentView(this , R.layout.activity_add_contact)
        val contactDao = ContactsRoomDataBase.getDatabase(application).contactDao()
        val contactRepository = ContactRepository(contactDao)
        val factory = AddContactViewModel.AddContactsViewModelFactory(contactRepository);
        addContactViewModel = ViewModelProvider(this,factory).get(AddContactViewModel:: class.java)
        binding.viewModel = addContactViewModel
        binding.lifecycleOwner = this
        setClickListeners()

        contact = intent.getParcelableExtra("Item")
        if(contact != null) {
        addContactViewModel.populateDetails(contact!!);
        }
    }

    private fun setClickListeners()
    {

    }
}
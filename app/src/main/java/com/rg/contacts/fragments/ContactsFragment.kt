package com.rg.contacts.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rg.contacts.R
import com.rg.contacts.databinding.FragmentContactsBinding
import com.rg.contacts.views.AddContact

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContactsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactsFragment : Fragment() {

    private lateinit var binding : FragmentContactsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       binding =  FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root

        setClickListeners()
    }


    private fun setClickListeners()
    {
        binding.fab.setOnClickListener{
            val addIntent = Intent(activity , AddContact :: class.java)
            startActivity(addIntent);
        }
    }


}
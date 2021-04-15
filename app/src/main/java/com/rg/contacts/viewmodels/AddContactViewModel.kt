package com.rg.contacts.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.rg.contacts.entities.Contact
import com.rg.contacts.repositories.ContactRepository
import kotlinx.coroutines.launch

class AddContactViewModel(private val repository: ContactRepository) : ViewModel() {

    val allContacts = repository.allContacts;
    var name = ObservableField<String>()
   var mobile = ObservableField<String>()

    fun saveOrUpdate()
    {
        val name = this.name.get()!!;
        val mobile = this.mobile.get()!!;
        insertContact(Contact(0 , name , mobile , ""))
        this.name.set(null)
        this.mobile.set(null)
    }

    fun deleteContact()
    {
        viewModelScope.launch {  }
    }

     fun insertContact(contact : Contact)
    {
        viewModelScope.launch {repository.insert(contact);  }

    }

    fun  updateContact(contact: Contact)
    {
        viewModelScope.launch { repository.update(contact) }
    }

    class AddContactsViewModelFactory(private val repository: ContactRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AddContactViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AddContactViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    fun populateDetails(contact: Contact)
    {
        name.set(contact.name)
        mobile.set(contact.mobile)
    }


}
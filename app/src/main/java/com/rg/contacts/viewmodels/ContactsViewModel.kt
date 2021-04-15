package com.rg.contacts.viewmodels
import androidx.lifecycle.*
import com.rg.contacts.entities.Contact
import com.rg.contacts.repositories.ContactRepository
import kotlinx.coroutines.launch
 class ContactsViewModel(private val repository: ContactRepository) :  ViewModel()  {

    val allContacts: LiveData<List<Contact>> = repository.allContacts.asLiveData()


    class ContactsViewModelFactory(private val repository: ContactRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ContactsViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ContactsViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}
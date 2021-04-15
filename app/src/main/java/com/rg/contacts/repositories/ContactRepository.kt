package com.rg.contacts.repositories
import androidx.annotation.WorkerThread
import com.rg.contacts.dao.ContactDao
import com.rg.contacts.entities.Contact
import kotlinx.coroutines.flow.Flow

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class ContactRepository (private val contactDao: ContactDao){

        // Room executes all queries on a separate thread.
        // Observed Flow will notify the observer when the data has changed.
        val allContacts: Flow<List<Contact>> = contactDao.getAllContacts();

        // By default Room runs suspend queries off the main thread, therefore, we don't need to
        // implement anything else to ensure we're not doing long running database work
        // off the main thread.
        @Suppress("RedundantSuspendModifier")
        @WorkerThread
        suspend fun insert(contact: Contact ) {
            contactDao.addContact(contact)
        }

        suspend fun update(contact: Contact ) {
                contactDao.updateContact(contact)
        }

        suspend fun delete(contact: Contact ) {
                contactDao.deleteContact(contact)
        }

}
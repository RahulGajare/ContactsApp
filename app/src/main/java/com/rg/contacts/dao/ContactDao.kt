package com.rg.contacts.dao

import androidx.room.*
import com.rg.contacts.entities.Contact
import kotlinx.coroutines.flow.Flow


@Dao
    interface ContactDao {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun addContact(contact : Contact)

        @Query("SELECT * FROM Contact ORDER BY name ASC")
        fun getAllContacts() : Flow<List<Contact>>

        @Update
        fun updateContact(contact : Contact)

        @Delete
        fun deleteContact(contact: Contact)
    }

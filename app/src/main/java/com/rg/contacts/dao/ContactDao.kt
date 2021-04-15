package com.rg.contacts.dao

import androidx.room.*
import com.rg.contacts.entities.Contact
import kotlinx.coroutines.flow.Flow


@Dao
    interface ContactDao {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend  fun addContact(contact : Contact)

        @Query("SELECT * FROM Contact ORDER BY name ASC")
         fun getAllContacts() : Flow<List<Contact>>

        @Update
        suspend fun updateContact(contact : Contact)

        @Delete
        suspend fun deleteContact(contact: Contact)
    }

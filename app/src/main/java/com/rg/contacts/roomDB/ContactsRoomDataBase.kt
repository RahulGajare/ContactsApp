package com.rg.contacts.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rg.contacts.dao.ContactDao
import com.rg.contacts.entities.Contact
import kotlinx.coroutines.CoroutineScope
@Database(entities = arrayOf(Contact::class), version = 1, exportSchema = false)
public abstract class ContactsRoomDataBase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {

        @Volatile
        private var INSTANCE: ContactsRoomDataBase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ContactsRoomDataBase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactsRoomDataBase::class.java,
                    "contat_dataBase"
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }
}
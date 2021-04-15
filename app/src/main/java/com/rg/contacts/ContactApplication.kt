package com.rg.contacts

import android.app.Application
import com.rg.contacts.repositories.ContactRepository
import com.rg.contacts.roomDB.ContactsRoomDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ContactApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ContactsRoomDataBase.getDatabase(this, applicationScope) }
    val repository by lazy { ContactRepository(database.contactDao()) }
}
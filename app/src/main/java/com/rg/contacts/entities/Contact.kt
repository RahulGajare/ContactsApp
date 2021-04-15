package com.rg.contacts.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class Contact(@PrimaryKey(autoGenerate = true) val id : Int,
                   val name: String,
                   val mobile: String,
                   val image : String) {
}
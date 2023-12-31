package com.example.roomcontactlist.listFeature.framework.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactTable")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
)

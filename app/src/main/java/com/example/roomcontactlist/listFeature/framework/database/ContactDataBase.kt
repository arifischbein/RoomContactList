package com.example.roomcontactlist.listFeature.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ContactEntity::class],
    version = 1
)
abstract class ContactDataBase: RoomDatabase() {

    abstract val contactDao: ContactDAO
}

package com.example.roomcontactlist.listFeature.framework.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contactEntity: ContactEntity)

    @Delete
    suspend fun deleteContact(contactEntity: ContactEntity)

    @Query("SELECT *  FROM contactTable ORDER BY  firstName ASC")
    suspend fun getContactsOrderByFirstName(): List<ContactEntity>

    @Query("SELECT *  FROM contactTable ORDER BY  lastName ASC")
    suspend fun getContactsOrderByLastName(): List<ContactEntity>

    @Query("SELECT *  FROM contactTable ORDER BY  phoneNumber ASC")
    suspend fun getContactsOrderByPhoneNumber(): List<ContactEntity>
}

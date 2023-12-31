package com.example.roomcontactlist.database

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
    fun getContactsOrderByFirstName(): LiveData<List<ContactEntity>>

    @Query("SELECT *  FROM contactTable ORDER BY  lastName ASC")
    fun getContactsOrderByLastName(): LiveData<List<ContactEntity>>

    @Query("SELECT *  FROM contactTable ORDER BY  phoneNumber ASC")
    fun getContactsOrderByPhoneNumber(): LiveData<List<ContactEntity>>
}

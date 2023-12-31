package com.example.roomcontactlist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT *  FROM contact ORDER BY  firstName ASC")
    fun getContactsOrderByFirstName(): LiveData<List<Contact>>

    @Query("SELECT *  FROM contact ORDER BY  lastName ASC")
    fun getContactsOrderByLastName(): LiveData<List<Contact>>

    @Query("SELECT *  FROM contact ORDER BY  phoneNumber ASC")
    fun getContactsOrderByPhoneNumber(): LiveData<List<Contact>>
}

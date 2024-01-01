package com.example.roomcontactlist.listFeature.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomcontactlist.listFeature.framework.database.ContactDAO
import com.example.roomcontactlist.listFeature.framework.database.ContactEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ContactListViewModel @Inject constructor(private val contactDb: ContactDAO) : ViewModel() {

    //Change model to uiModel
    private val _contactListLD: MutableLiveData<List<ContactEntity>> = MutableLiveData()
    val contactListLD: LiveData<List<ContactEntity>> get() = _contactListLD

    init {
        getContactListOrderByName()
    }

    fun addNewContact(contact: ContactEntity) {
        viewModelScope.launch {
            contactDb.insertContact(contact)
            val currentList = _contactListLD.value.orEmpty().toMutableList()
            currentList.add(contact)
            _contactListLD.value = currentList
        }
    }

    fun deleteContact(contact: ContactEntity) {
        viewModelScope.launch {
            val currentList = _contactListLD.value.orEmpty().toMutableList()
            contactDb.deleteContact(contact)
            currentList.remove(contact)
            _contactListLD.value = currentList
        }
    }

    fun getContactListOrderByName() {
        viewModelScope.launch {
            val contacts = contactDb.getContactsOrderByFirstName()
            _contactListLD.value = contacts
        }
    }
}

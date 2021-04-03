package com.sri.contactdemo.ui.contactsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sri.contactdemo.data.Contact
import com.sri.contactdemo.data.Repository

import javax.inject.Inject

class ContactsListViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    val getAllContacts = repository.getAllContacts()

    fun findContactByName(query: String): LiveData<List<Contact>> {
        return repository.findContactByName(query)
    }

}
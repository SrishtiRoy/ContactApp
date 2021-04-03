package com.sri.contactdemo.di.contactsList

import androidx.lifecycle.ViewModel
import com.sri.contactdemo.di.ViewModelKey
import com.sri.contactdemo.ui.contactsList.ContactsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ContactsListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactsListViewModel::class)
    abstract fun bindContactsListViewModel(contactsListViewModel: ContactsListViewModel): ViewModel

}
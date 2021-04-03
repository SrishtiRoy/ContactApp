package com.aishwaryakamal.contactspro.di.addContact

import androidx.lifecycle.ViewModel

import com.sri.contactdemo.di.ViewModelKey
import com.sri.contactdemo.ui.addContact.AddContactViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AddContactViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddContactViewModel::class)
    abstract fun bindAddContactViewModel(addContactViewModel: AddContactViewModel): ViewModel

}
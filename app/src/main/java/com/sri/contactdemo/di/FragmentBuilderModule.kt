package com.sri.contactdemo.di

import com.aishwaryakamal.contactspro.di.addContact.AddContactViewModelModule


import com.sri.contactdemo.di.contactDetails.ContactDetailsViewModelModule
import com.sri.contactdemo.di.contactsList.ContactsListViewModelModule
import com.sri.contactdemo.ui.addContact.AddContactFragment
import com.sri.contactdemo.ui.contactDetails.ContactDetailsFragment
import com.sri.contactdemo.ui.contactsList.ContactsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [ContactsListViewModelModule::class])
    abstract fun contributeContactsFragment() : ContactsListFragment

    @ContributesAndroidInjector(modules = [AddContactViewModelModule::class])
    abstract fun contributeAddContactFragment() : AddContactFragment

    @ContributesAndroidInjector(modules = [ContactDetailsViewModelModule::class])
    abstract fun contributeContactDetailsFragment() : ContactDetailsFragment
}
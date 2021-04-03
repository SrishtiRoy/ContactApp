package com.sri.contactdemo.di

import android.content.Context
import androidx.room.Room

import com.sri.contactdemo.DATABASE_NAME
import com.sri.contactdemo.data.Repository
import com.sri.contactdemo.data.local.ContactDao
import com.sri.contactdemo.local.ContactRoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideContactDao(contactRoomDatabase: ContactRoomDatabase): ContactDao {
        return contactRoomDatabase.contactDao()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideContactDatabase(context: Context): ContactRoomDatabase {
        return Room.databaseBuilder(context, ContactRoomDatabase::class.java, DATABASE_NAME).build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideContactRepository(contactDao: ContactDao): Repository {
        return Repository(contactDao)
    }

}
package com.sri.contactdemo.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sri.contactdemo.data.Contact
import com.sri.contactdemo.data.local.ContactDao

@Database(entities = arrayOf(Contact::class), version = 1, exportSchema = false)
abstract class ContactRoomDatabase : RoomDatabase(){

    abstract fun contactDao(): ContactDao
}
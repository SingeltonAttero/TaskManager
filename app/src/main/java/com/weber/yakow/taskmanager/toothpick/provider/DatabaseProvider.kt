package com.weber.yakow.taskmanager.toothpick.provider

import android.arch.persistence.room.Room
import android.content.Context
import com.weber.yakow.taskmanager.model.data.storage.db.AppDatabase
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */

class DatabaseProvider @Inject constructor(val context: Context): Provider<AppDatabase> {
    override fun get(): AppDatabase = Room.databaseBuilder(context,AppDatabase::class.java,"database").build()
}
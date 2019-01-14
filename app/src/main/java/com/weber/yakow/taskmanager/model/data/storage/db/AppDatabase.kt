package com.weber.yakow.taskmanager.model.data.storage.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.weber.yakow.taskmanager.model.data.storage.db.dao.PersonContentDao
import com.weber.yakow.taskmanager.model.data.storage.db.entity.PersonContent

/**
 * Created on 13.01.19
 * @author YWeber
 * project TaskManager */

@Database(
    entities = [PersonContent::class],
    version = 1, exportSchema = false
)
 abstract class AppDatabase : RoomDatabase() {
    abstract fun personContentDao(): PersonContentDao
}
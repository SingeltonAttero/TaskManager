package com.weber.yakow.taskmanager.toothpick.provider

import com.weber.yakow.taskmanager.model.data.storage.db.AppDatabase
import com.weber.yakow.taskmanager.model.data.storage.db.dao.PersonContentDao
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */
class PersonContentDaoProvider @Inject constructor(private val appDatabase: AppDatabase) : Provider<PersonContentDao> {
    override fun get(): PersonContentDao = appDatabase.personContentDao()
}
package com.weber.yakow.taskmanager.model.repository.manager

import com.weber.yakow.taskmanager.extension.printConstruction
import com.weber.yakow.taskmanager.model.data.storage.db.dao.PersonContentDao
import com.weber.yakow.taskmanager.model.data.storage.db.entity.PersonContent
import com.weber.yakow.taskmanager.system.shceduler.SchedulersProvider
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created on 16.01.19
 * @author YWeber
 * project TaskManager */

class TaskManagerRepository @Inject constructor(
    private val personDao: PersonContentDao,
    private val schedulers: SchedulersProvider
) {
    init {
        printConstruction()
    }

    fun getPerson(): Flowable<List<PersonContent>> = personDao.getAll()
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
}
package com.weber.yakow.taskmanager.model.repository

import com.weber.yakow.taskmanager.extension.printConstruction
import com.weber.yakow.taskmanager.model.data.storage.db.dao.PersonContentDao
import com.weber.yakow.taskmanager.model.data.storage.db.entity.PersonContent
import com.weber.yakow.taskmanager.system.shceduler.SchedulersProvider
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */

class MainRepository @Inject constructor(
    private val personDao: PersonContentDao,
    private val schedulers: SchedulersProvider
) {

    private val listDataSource: MutableList<PersonContent>

    init {
        printConstruction()
        listDataSource = mutableListOf()
        for (i in 0..100) {
            listDataSource.add(
                PersonContent(
                    nameUser = "yakow$i",
                    taskText = "test$i",
                    priority = i,
                    saveTime = "11,22",
                    text = "test$i"
                )
            )
        }
    }

    fun savePersonContent(): Completable = Completable.fromCallable {
        personDao.insertAll(listDataSource)
    }.subscribeOn(schedulers.io()).observeOn(schedulers.ui())

    fun getPersonContent(): Flowable<List<PersonContent>> = personDao.getAll()
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.ui())
}
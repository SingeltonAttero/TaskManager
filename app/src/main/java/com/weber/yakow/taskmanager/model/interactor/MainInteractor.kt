package com.weber.yakow.taskmanager.model.interactor

import com.weber.yakow.taskmanager.extension.printConstruction
import com.weber.yakow.taskmanager.model.data.storage.db.entity.PersonContent
import com.weber.yakow.taskmanager.model.repository.MainRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */

class MainInteractor @Inject constructor(private val repository: MainRepository) {
    init {
        printConstruction()
    }
    fun dataSaveContent(): Completable = repository.savePersonContent()
    fun getPersonContent(): Flowable<List<PersonContent>> = repository.getPersonContent()
}
package com.weber.yakow.taskmanager.model.interactor.manager

import com.weber.yakow.taskmanager.entity.Task
import com.weber.yakow.taskmanager.extension.printConstruction
import com.weber.yakow.taskmanager.model.repository.manager.TaskManagerRepository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created on 16.01.19
 * @author YWeber
 * project TaskManager */

class TaskManagerInteractor @Inject constructor(private val repository: TaskManagerRepository) {
    init {
        this.printConstruction()
    }
    fun getTask(): Flowable<List<Task>> = repository.getPerson()
        .map { listPerson -> listPerson.map { Task(name = it.nameUser, description = it.taskText, date = it.saveTime) } }
}
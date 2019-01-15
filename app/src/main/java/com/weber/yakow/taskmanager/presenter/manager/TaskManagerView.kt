package com.weber.yakow.taskmanager.presenter.manager

import com.arellomobile.mvp.MvpView
import com.weber.yakow.taskmanager.entity.Task

/**
 * Created on 16.01.19
 * @author YWeber
 * project TaskManager */

interface TaskManagerView : MvpView {
    fun bindPerson(persons: List<Task>)
}
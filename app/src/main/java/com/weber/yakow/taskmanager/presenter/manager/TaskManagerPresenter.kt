package com.weber.yakow.taskmanager.presenter.manager

import com.arellomobile.mvp.InjectViewState
import com.weber.yakow.taskmanager.model.interactor.manager.TaskManagerInteractor
import com.weber.yakow.taskmanager.presenter.global.BasePresenter
import com.weber.yakow.taskmanager.system.ResourceManager
import timber.log.Timber
import javax.inject.Inject

/**
 * Created on 16.01.19
 * @author YWeber
 * project TaskManager */
@InjectViewState
class TaskManagerPresenter @Inject constructor(
    private val resourceManager: ResourceManager,
    private val interactor: TaskManagerInteractor
) : BasePresenter<TaskManagerView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        interactor.getTask()
            .subscribe({
                viewState.bindPerson(it)
            }, {
                Timber.e(it)
            }).bind()
    }
}
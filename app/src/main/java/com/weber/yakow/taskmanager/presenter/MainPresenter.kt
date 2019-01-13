package com.weber.yakow.taskmanager.presenter

import com.arellomobile.mvp.InjectViewState
import com.weber.yakow.taskmanager.extension.printConstruction
import com.weber.yakow.taskmanager.model.interactor.MainInteractor
import com.weber.yakow.taskmanager.presenter.global.BasePresenter
import com.weber.yakow.taskmanager.system.ResourceManager
import timber.log.Timber
import javax.inject.Inject

/**
 * Created on 09.01.19
 * @author YWeber
 * project TaskManager */
@InjectViewState
class MainPresenter @Inject constructor(private val resourceManager: ResourceManager,
                                        private val interactor: MainInteractor
) : BasePresenter<MainView>() {
    init {
        printConstruction()
    }

    override fun onFirstViewAttach() {
        interactor.dataSaveContent()
            .subscribe({
                 interactor.getPersonContent()
                     .subscribe({
                         viewState.setText(it.toString())
                     },{

                     })
                }, {
                    Timber.e(it)
                }
            ).bind()
    }

}
package com.weber.yakow.taskmanager.presenter.auth

import com.arellomobile.mvp.InjectViewState
import com.weber.yakow.taskmanager.Screens
import com.weber.yakow.taskmanager.extension.printConstruction
import com.weber.yakow.taskmanager.model.interactor.MainInteractor
import com.weber.yakow.taskmanager.presenter.global.BasePresenter
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

/**
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */
@InjectViewState
class AuthPresenter @Inject constructor(
    private val router: Router,
    private val interactor: MainInteractor
) : BasePresenter<AuthView>() {
    init {
        printConstruction()
    }

    fun goToManagerFlow() {
        interactor.dataSaveContent()
            .subscribe({
                router.replaceScreen(Screens.TaskManagerFlow)
            }, {
                Timber.e(it)
            }).bind()
    }
}
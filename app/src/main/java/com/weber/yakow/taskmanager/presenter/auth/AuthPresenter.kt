package com.weber.yakow.taskmanager.presenter.auth

import com.arellomobile.mvp.InjectViewState
import com.weber.yakow.taskmanager.Screens
import com.weber.yakow.taskmanager.extension.printConstruction
import com.weber.yakow.taskmanager.presenter.global.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */
@InjectViewState
class AuthPresenter @Inject constructor(private val router: Router) : BasePresenter<AuthView>() {
    init {
        printConstruction()
    }

    fun goToManagerFlow() = router.replaceScreen(Screens.TaskManagerFlow)
}
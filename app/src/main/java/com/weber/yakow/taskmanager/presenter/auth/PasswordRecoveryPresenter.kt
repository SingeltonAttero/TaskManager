package com.weber.yakow.taskmanager.presenter.auth

import com.arellomobile.mvp.InjectViewState
import com.weber.yakow.taskmanager.Screens
import com.weber.yakow.taskmanager.presenter.global.BasePresenter
import com.weber.yakow.taskmanager.system.FlowRouter
import javax.inject.Inject

/**
 * Created on 18.01.19
 * @author YWeber
 * project TaskManager */
@InjectViewState
class PasswordRecoveryPresenter @Inject constructor(private val flowRouter: FlowRouter) :
    BasePresenter<PasswordRecoveryView>() {

    fun onBackPressed() = flowRouter.newRootFlow(Screens.AuthScreen)

}
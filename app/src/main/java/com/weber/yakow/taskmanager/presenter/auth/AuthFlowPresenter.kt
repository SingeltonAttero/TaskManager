package com.weber.yakow.taskmanager.presenter.auth

import com.arellomobile.mvp.InjectViewState
import com.weber.yakow.taskmanager.extension.printConstruction
import com.weber.yakow.taskmanager.presenter.global.BasePresenter
import javax.inject.Inject

/**
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */
@InjectViewState
class AuthFlowPresenter @Inject constructor() : BasePresenter<AuthFlowView>() {
    init {
        printConstruction()
    }
}
package com.weber.yakow.taskmanager.presenter

import com.arellomobile.mvp.InjectViewState
import com.weber.yakow.taskmanager.R
import com.weber.yakow.taskmanager.presenter.global.BasePresenter
import com.weber.yakow.taskmanager.system.ResourceManager
import javax.inject.Inject

/**
 * Created on 09.01.19
 * @author YWeber
 * project TaskManager */
@InjectViewState
class MainPresenter @Inject constructor(private val resourceManager: ResourceManager) : BasePresenter<MainView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

}
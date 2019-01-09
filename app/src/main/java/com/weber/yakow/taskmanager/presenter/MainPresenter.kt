package com.weber.yakow.taskmanager.presenter

import com.arellomobile.mvp.InjectViewState
import com.weber.yakow.taskmanager.R
import com.weber.yakow.taskmanager.extension.printConstruction
import com.weber.yakow.taskmanager.model.storage.prefs.CommonsPrefs
import com.weber.yakow.taskmanager.presenter.global.BasePresenter
import com.weber.yakow.taskmanager.system.ResourceManager
import java.util.*
import javax.inject.Inject

/**
 * Created on 09.01.19
 * @author YWeber
 * project TaskManager */
@InjectViewState
class MainPresenter @Inject constructor(private val resourceManager: ResourceManager,
                                        private val commonsPrefs: CommonsPrefs) : BasePresenter<MainView>(){
    init {
        printConstruction()
        commonsPrefs.firstLaunchFlag = true
        commonsPrefs.dataFirstLaunch = Date().toString()
    }

    override fun onFirstViewAttach() {
        viewState.setText("${commonsPrefs.dataFirstLaunch} : ${commonsPrefs.firstLaunchFlag}")
    }

}
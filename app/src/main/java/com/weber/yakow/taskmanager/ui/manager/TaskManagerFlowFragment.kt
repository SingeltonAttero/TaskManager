package com.weber.yakow.taskmanager.ui.manager

import android.os.Bundle
import android.view.View
import com.weber.yakow.taskmanager.Screens
import com.weber.yakow.taskmanager.extension.setLaunchScreen
import com.weber.yakow.taskmanager.toothpick.DI
import com.weber.yakow.taskmanager.toothpick.module.NavigationModule
import com.weber.yakow.taskmanager.toothpick.qualifier.InnerNavigationHolder
import com.weber.yakow.taskmanager.ui.global.BaseFlowFragment
import org.jetbrains.anko.support.v4.toast
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 15.01.19
 * @author YWeber
 * project TaskManager */

class TaskManagerFlowFragment : BaseFlowFragment() {

    @Inject
    @InnerNavigationHolder
    override lateinit var navigatorHolder: NavigatorHolder

    companion object {
        fun newInstance(): TaskManagerFlowFragment = TaskManagerFlowFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()){
            navigator.setLaunchScreen(Screens.TaskManagerScreen)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(true)
    }

    override fun initScope() {
        val openScopes = Toothpick.openScopes(DI.APP_SCOPE, DI.NAVIGATION_SCOPE)
        openScopes.installModules(NavigationModule(openScopes.getInstance(Router::class.java)))
        Toothpick.inject(this,openScopes)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        toast("back")
    }
}
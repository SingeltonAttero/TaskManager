package com.weber.yakow.taskmanager.toothpick.module

import com.weber.yakow.taskmanager.system.FlowRouter
import com.weber.yakow.taskmanager.toothpick.qualifier.InnerNavigationHolder
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber
import toothpick.config.Module

/**
 * Created on 13.12.18
 * @author YWeber
 * project BusinessCart */

class NavigationModule(router: Router) : Module() {
    init {
        Timber.d("init inner navigation scope")
        val cicerone = Cicerone.create(FlowRouter(router))
        bind(FlowRouter::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(InnerNavigationHolder::class.java).toInstance(cicerone.navigatorHolder)
    }
}
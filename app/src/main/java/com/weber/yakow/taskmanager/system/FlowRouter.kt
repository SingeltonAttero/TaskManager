package com.weber.yakow.taskmanager.system

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen

/**
 * Created on 13.12.18
 * @author YWeber
 * project BusinessCart */

class FlowRouter(private val appRouter: Router) : Router() {
    fun startFlow(screen: Screen) = appRouter.navigateTo(screen)

    fun newRootFlow(screen: Screen) = appRouter.newRootScreen(screen)

    fun toExit() = appRouter.exit()
}
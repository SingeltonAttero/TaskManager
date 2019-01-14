package com.weber.yakow.taskmanager.ui.manager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.weber.yakow.taskmanager.R
import com.weber.yakow.taskmanager.Screens
import com.weber.yakow.taskmanager.extension.setLaunchScreen
import com.weber.yakow.taskmanager.toothpick.DI
import com.weber.yakow.taskmanager.toothpick.module.NavigationModule
import com.weber.yakow.taskmanager.toothpick.qualifier.InnerNavigationHolder
import com.weber.yakow.taskmanager.ui.global.BaseFragment
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 15.01.19
 * @author YWeber
 * project TaskManager */

class TaskManagerFlowFragment : BaseFragment() {

    companion object {
        fun newInstance(): TaskManagerFlowFragment = TaskManagerFlowFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_flow_conteiner

    @Inject
    @InnerNavigationHolder
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: SupportAppNavigator by lazy {
        object : SupportAppNavigator(activity,childFragmentManager,R.id.baseFlowContainer){
            override fun setupFragmentTransaction(command: Command?,
                                                  currentFragment: Fragment?,
                                                  nextFragment: Fragment?,
                                                  fragmentTransaction: FragmentTransaction?) {
                super.setupFragmentTransaction(command, currentFragment, nextFragment, fragmentTransaction)
                fragmentTransaction?.setReorderingAllowed(true)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initScope()
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()){
            navigator.setLaunchScreen(Screens.TaskManagerScreen)
        }

    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun initScope() {
        val openScopes = Toothpick.openScopes(DI.APP_SCOPE, DI.NAVIGATION_SCOPE)
        openScopes.installModules(NavigationModule(openScopes.getInstance(Router::class.java)))
        Toothpick.inject(this,openScopes)
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }
}
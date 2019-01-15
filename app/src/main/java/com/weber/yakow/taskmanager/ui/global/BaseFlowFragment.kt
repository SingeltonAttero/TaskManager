package com.weber.yakow.taskmanager.ui.global

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.weber.yakow.taskmanager.R
import kotlinx.android.synthetic.main.toolbar.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

/**
 * Created on 15.01.19
 * @author YWeber
 * project TaskManager */

abstract class BaseFlowFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_flow_conteiner

    abstract val navigatorHolder: NavigatorHolder

    abstract fun initScope()

    protected val navigator: SupportAppNavigator by lazy {
        object : SupportAppNavigator(activity, childFragmentManager, R.id.baseFlowContainer) {
            override fun activityBack() {
                onBackPressed()
            }

            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction?
            ) {
                super.setupFragmentTransaction(
                    command,
                    currentFragment,
                    nextFragment,
                    fragmentTransaction
                )
                fragmentTransaction?.setReorderingAllowed(true)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initScope()
        super.onCreate(savedInstanceState)
    }

    protected fun initToolbar(isBackTo: Boolean) {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(isBackTo)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
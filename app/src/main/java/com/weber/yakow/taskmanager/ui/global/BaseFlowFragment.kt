package com.weber.yakow.taskmanager.ui.global

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.weber.yakow.taskmanager.R
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.toast
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

    private val currentFragment: BaseFragment?
        get() = childFragmentManager.findFragmentById(R.id.baseFlowContainer) as BaseFragment

    protected val navigator: SupportAppNavigator by lazy {
        object : SupportAppNavigator(activity, childFragmentManager, R.id.baseFlowContainer) {
            override fun activityBack() {
                onExit()
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

    protected fun initToolbar(isBackTo: Boolean,title:String = getString(R.string.app_name)) {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.title = title
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(isBackTo)
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    open fun onExit() {}

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
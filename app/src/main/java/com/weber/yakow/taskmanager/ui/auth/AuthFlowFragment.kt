package com.weber.yakow.taskmanager.ui.auth

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weber.yakow.taskmanager.R
import com.weber.yakow.taskmanager.Screens
import com.weber.yakow.taskmanager.extension.setLaunchScreen
import com.weber.yakow.taskmanager.presenter.auth.AuthFlowPresenter
import com.weber.yakow.taskmanager.presenter.auth.AuthFlowView
import com.weber.yakow.taskmanager.toothpick.DI
import com.weber.yakow.taskmanager.toothpick.module.NavigationModule
import com.weber.yakow.taskmanager.toothpick.qualifier.InnerNavigationHolder
import com.weber.yakow.taskmanager.ui.global.BaseFragment
import org.jetbrains.anko.support.v4.toast
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import toothpick.Toothpick
import javax.inject.Inject

/**
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */

class AuthFlowFragment : BaseFragment(), AuthFlowView {

    companion object {
        fun newInstance(): AuthFlowFragment = AuthFlowFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_flow_conteiner

    @InjectPresenter
    lateinit var presenter:AuthFlowPresenter

    @ProvidePresenter
    fun presenterProvider(): AuthFlowPresenter = Toothpick.openScope(DI.NAVIGATION_SCOPE)
            .getInstance(AuthFlowPresenter::class.java)

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
            navigator.setLaunchScreen(Screens.AuthScreen)
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
        toast("test")
    }
}
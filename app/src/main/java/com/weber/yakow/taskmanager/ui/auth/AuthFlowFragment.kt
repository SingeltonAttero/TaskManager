package com.weber.yakow.taskmanager.ui.auth

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weber.yakow.taskmanager.Screens
import com.weber.yakow.taskmanager.extension.setLaunchScreen
import com.weber.yakow.taskmanager.presenter.auth.AuthFlowPresenter
import com.weber.yakow.taskmanager.presenter.auth.AuthFlowView
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
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */

class AuthFlowFragment : BaseFlowFragment(), AuthFlowView {

    companion object {
        fun newInstance(): AuthFlowFragment = AuthFlowFragment()
    }

    @InjectPresenter
    lateinit var presenter:AuthFlowPresenter

    @ProvidePresenter
    fun presenterProvider(): AuthFlowPresenter = Toothpick
        .openScope(DI.NAVIGATION_SCOPE)
        .getInstance(AuthFlowPresenter::class.java)

    @Inject
    @InnerNavigationHolder
    override lateinit var navigatorHolder: NavigatorHolder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()){
            navigator.setLaunchScreen(Screens.AuthScreen)
        }

    }

    override fun initScope() {
        val openScopes = Toothpick.openScopes(DI.APP_SCOPE, DI.NAVIGATION_SCOPE)
        openScopes.installModules(NavigationModule(openScopes.getInstance(Router::class.java)))
        Toothpick.inject(this,openScopes)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        toast("test")
    }
}
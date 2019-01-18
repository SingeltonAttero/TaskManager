package com.weber.yakow.taskmanager.ui.auth

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weber.yakow.taskmanager.R
import com.weber.yakow.taskmanager.presenter.auth.PasswordRecoveryPresenter
import com.weber.yakow.taskmanager.presenter.auth.PasswordRecoveryView
import com.weber.yakow.taskmanager.toothpick.DI
import com.weber.yakow.taskmanager.ui.global.BaseFragment
import toothpick.Toothpick

/**
 * Created on 18.01.19
 * @author YWeber
 * project TaskManager */

class PasswordRecoveryFragment : BaseFragment(), PasswordRecoveryView {

    companion object {
        fun newInstance(): PasswordRecoveryFragment = PasswordRecoveryFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_password_recovery
    @InjectPresenter
    lateinit var presenter:PasswordRecoveryPresenter

    @ProvidePresenter
    fun presenterProvider(): PasswordRecoveryPresenter = Toothpick
        .openScope(DI.NAVIGATION_SCOPE)
        .getInstance(PasswordRecoveryPresenter::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.password_recover)
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

}
package com.weber.yakow.taskmanager.ui.auth

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.jakewharton.rxbinding2.view.RxView
import com.weber.yakow.taskmanager.R
import com.weber.yakow.taskmanager.presenter.auth.AuthPresenter
import com.weber.yakow.taskmanager.presenter.auth.AuthView
import com.weber.yakow.taskmanager.toothpick.DI
import com.weber.yakow.taskmanager.ui.global.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_auth.*
import toothpick.Toothpick
import java.util.concurrent.TimeUnit

/**
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */

class AuthFragment : BaseFragment(), AuthView {

    companion object {
        fun newInstance(): AuthFragment = AuthFragment()
    }

    @InjectPresenter
    lateinit var presenter: AuthPresenter

    @ProvidePresenter
    fun presenterProvider(): AuthPresenter = Toothpick
            .openScope(DI.NAVIGATION_SCOPE)
            .getInstance(AuthPresenter::class.java)

    override val layoutRes: Int
        get() = R.layout.fragment_auth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RxView.clicks(loginButton)
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    presenter.goToManagerFlow()
                }.bind()
         RxView.clicks(passwordRecoverView)
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    presenter.toGoPasswordRecoverScreen()
                }.bind()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.sing_in)

    }

    override fun showProgress(progress: Boolean) {
        progressDialog(progress)
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

}
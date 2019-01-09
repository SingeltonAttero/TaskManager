package com.weber.yakow.taskmanager.ui

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.weber.yakow.taskmanager.R
import com.weber.yakow.taskmanager.presenter.MainPresenter
import com.weber.yakow.taskmanager.presenter.MainView
import com.weber.yakow.taskmanager.toothpick.DI
import kotlinx.android.synthetic.main.activity_main.*
import toothpick.Toothpick

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providerPresenter(): MainPresenter = Toothpick
        .openScope(DI.APP_SCOPE)
        .getInstance(MainPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

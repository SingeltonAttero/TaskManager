package com.weber.yakow.taskmanager.presenter.global

import android.text.method.TextKeyListener.clear
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.weber.yakow.taskmanager.system.disposable.ComponentDisposableBind
import com.weber.yakow.taskmanager.system.disposable.ComponentDisposableBindImpl

/**
 * Created on 09.01.19
 * @author YWeber
 * project TaskManager */

open class BasePresenter<V : MvpView> : MvpPresenter<V>(), ComponentDisposableBind by ComponentDisposableBindImpl() {
    override fun onDestroy() {
        clear()
        super.onDestroy()
    }
}
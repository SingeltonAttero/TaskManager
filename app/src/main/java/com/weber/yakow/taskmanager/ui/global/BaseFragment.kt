package com.weber.yakow.taskmanager.ui.global

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.weber.yakow.taskmanager.system.disposable.ComponentDisposableBind
import com.weber.yakow.taskmanager.system.disposable.ComponentDisposableBindImpl
import timber.log.Timber

/**
 * Created on 09.01.19
 * @author YWeber
 * project TaskManager */

abstract class BaseFragment : MvpAppCompatFragment(), ComponentDisposableBind by ComponentDisposableBindImpl() {

    abstract val layoutRes: Int @LayoutRes get

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onDestroy() {
        clear()
        super.onDestroy()
    }

    open fun onBackPressed(){Timber.d("back pressed")}
}
package com.weber.yakow.taskmanager.ui.global

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.weber.yakow.taskmanager.system.disposable.ComponentDisposableBind
import com.weber.yakow.taskmanager.system.disposable.ComponentDisposableBindImpl
import com.weber.yakow.taskmanager.ui.global.dialog.ProgressDialog
import timber.log.Timber

/**
 * Created on 09.01.19
 * @author YWeber
 * project TaskManager */

private const val PROGRESS_DIALOG = "dialog progress"

abstract class BaseFragment : MvpAppCompatFragment(), ComponentDisposableBind by ComponentDisposableBindImpl() {

    abstract val layoutRes: Int @LayoutRes get

    private var instanceSaveState:Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onDestroy() {
        clear()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        instanceSaveState = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        instanceSaveState = true
    }

    fun progressDialog(progress:Boolean){
        if (!isAdded || instanceSaveState)return
        val fragment: Fragment? = childFragmentManager.findFragmentByTag(PROGRESS_DIALOG)
        if (fragment != null && !progress){
            (fragment as ProgressDialog).dismissAllowingStateLoss()
            childFragmentManager.executePendingTransactions()
        }else if (fragment == null && progress){
            ProgressDialog().show(childFragmentManager, PROGRESS_DIALOG)
            childFragmentManager.executePendingTransactions()
        }
    }

    open fun onBackPressed() {}
}
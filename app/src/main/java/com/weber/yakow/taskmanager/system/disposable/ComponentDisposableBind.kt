package com.weber.yakow.taskmanager.system.disposable

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

interface ComponentDisposableBind {
    val compositeDisposable: CompositeDisposable
    fun clear()
    fun Disposable.bind()
}
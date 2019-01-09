package com.weber.yakow.taskmanager.system.disposable

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created on 11.12.18
 * @author YWeber
 * project BusinessCart */

class ComponentDisposableBindImpl : ComponentDisposableBind {
    override val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun clear() {
        compositeDisposable.clear()
    }

    override fun Disposable.bind() {
        compositeDisposable.add(this)
    }
}
package com.weber.yakow.taskmanager.system.shceduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created on 11.12.18
 * @author YWeber
 * project BusinessCart */

class AppScheduler : SchedulersProvider {
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
    override fun io(): Scheduler = Schedulers.io()
    override fun newThread(): Scheduler = Schedulers.newThread()
    override fun computation(): Scheduler = Schedulers.computation()
    override fun trampoline(): Scheduler = Schedulers.trampoline()
}
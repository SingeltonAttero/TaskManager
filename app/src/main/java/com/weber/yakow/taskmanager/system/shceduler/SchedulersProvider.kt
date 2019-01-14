package com.weber.yakow.taskmanager.system.shceduler

import io.reactivex.Scheduler

/**
 * Created on 11.12.18
 * @author YWeber
 * project BusinessCart */

interface SchedulersProvider {
    fun ui(): Scheduler
    fun io(): Scheduler
    fun newThread(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
}
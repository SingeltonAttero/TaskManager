package com.weber.yakow.taskmanager.system.message

import com.jakewharton.rxrelay2.PublishRelay

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

class SystemMessageNotifier() {
    private val systemMessageNotifier = PublishRelay.create<SystemMessage>()
    fun notifier() = systemMessageNotifier.hide()
    fun systemMessage(message: String) = systemMessageNotifier.accept(SystemMessage(message))
    fun systemMessage(message: String, type: SystemMessageType) = systemMessageNotifier.accept(SystemMessage(message, type))
}
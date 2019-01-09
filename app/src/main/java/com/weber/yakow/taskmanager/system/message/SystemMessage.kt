package com.weber.yakow.taskmanager.system.message

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

data class SystemMessage(
    val message: String,
    val type: SystemMessageType = SystemMessageType.TOAST
)
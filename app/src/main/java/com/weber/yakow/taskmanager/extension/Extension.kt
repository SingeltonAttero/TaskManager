package com.weber.yakow.taskmanager.extension

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import timber.log.Timber

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

// init simple name construction
inline fun <reified T> T.printConstruction() = Timber.d("Construction: ${T::class.java.simpleName}")

// debug logger
fun <T> T.alsoPrintDebug(message: String = "Timber logger"): T = this.also { Timber.d("$message : $this") }

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)
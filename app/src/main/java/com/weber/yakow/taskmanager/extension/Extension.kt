package com.weber.yakow.taskmanager.extension

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weber.yakow.taskmanager.Screens
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace
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

fun Navigator.setLaunchScreen(screen: Screen){
    applyCommands(arrayOf(
        BackTo(null),
        Replace(screen)
    ))
}
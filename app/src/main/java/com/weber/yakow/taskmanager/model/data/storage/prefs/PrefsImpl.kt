package com.weber.yakow.taskmanager.model.data.storage.prefs

import android.content.Context
import android.content.SharedPreferences
import org.jetbrains.anko.defaultSharedPreferences
import javax.inject.Inject

/**
 * Created on 10.01.19
 * @author YWeber
 * project TaskManager */

class PrefsImpl @Inject constructor(private val context: Context) : CommonsPrefs {

    companion object {
        const val FIRST_LAUNCH_FLAG = "first launch flag"
        const val DATE_FIRST_LAUNCH = "date first launch"
    }

    private val sharedPrefs by lazy { context.defaultSharedPreferences }

    private inline fun SharedPreferences.edit(editor: SharedPreferences.Editor.() -> Unit) {
        edit().apply { editor() }.apply()
    }

    override var firstLaunchFlag: Boolean
        get() = sharedPrefs.getBoolean(FIRST_LAUNCH_FLAG, false)
        set(value) {
            sharedPrefs.edit { putBoolean(FIRST_LAUNCH_FLAG, value) }
        }
    override var dataFirstLaunch: String
        get() = sharedPrefs.getString(DATE_FIRST_LAUNCH, "00:00") ?: ""
        set(value) {
            sharedPrefs.edit { putString(DATE_FIRST_LAUNCH, value) }
        }
}
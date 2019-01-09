package com.weber.yakow.taskmanager.system

import android.content.Context
import android.support.annotation.StringRes
import java.io.InputStream

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

class ResourceManager(private val context: Context) {

    fun getString(@StringRes resId: Int): String = context.resources.getString(resId)

    fun getString(@StringRes resId: Int, vararg formatArgs: Any?): String = context.resources.getString(resId, *formatArgs)

    fun getAsset(name: String): InputStream = context.resources.assets.open(name)
}
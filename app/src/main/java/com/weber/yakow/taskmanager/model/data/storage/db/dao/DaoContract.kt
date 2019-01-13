package com.weber.yakow.taskmanager.model.data.storage.db.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created on 14.01.19
 * @author YWeber
 * project TaskManager */

interface DaoContract<in Key : Any, Value : Any> {
    @Insert(onConflict = REPLACE)
    fun insert(element: Value)

    @Insert(onConflict = REPLACE)
    @JvmSuppressWildcards
    fun insertAll(elements: List<Value>)

    @Delete
    fun delete(element: Value)
}
package com.weber.yakow.taskmanager.model.data.storage.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created on 13.01.19
 * @author YWeber
 * project TaskManager */

@Entity(tableName = "person_content")
data class PersonContent (
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val nameUser:String,
    val text:String,
    val saveTime:String,
    val priority:Int,
    val taskText:String)
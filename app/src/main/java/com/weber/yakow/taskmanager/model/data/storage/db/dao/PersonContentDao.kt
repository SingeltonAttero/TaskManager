package com.weber.yakow.taskmanager.model.data.storage.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.weber.yakow.taskmanager.model.data.storage.db.entity.PersonContent
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created on 13.01.19
 * @author YWeber
 * project TaskManager */

@Dao
abstract class PersonContentDao : DaoContract<Int, PersonContent> {
    @Query("DELETE FROM person_content WHERE id = :key")
    abstract fun deleteByKey(key: Int)

    @Query("DELETE FROM person_content")
    abstract fun deleteAll()

    @Query("SELECT * FROM person_content WHERE id = :key")
    abstract fun getByKey(key: Int): Single<PersonContent>

    @Query("SELECT * FROM person_content")
    abstract fun getAll(): Flowable<List<PersonContent>>
}
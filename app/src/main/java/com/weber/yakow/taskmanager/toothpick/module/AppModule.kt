package com.weber.yakow.taskmanager.toothpick.module

import android.content.Context
import com.weber.yakow.taskmanager.model.data.storage.db.AppDatabase
import com.weber.yakow.taskmanager.model.data.storage.db.dao.PersonContentDao
import com.weber.yakow.taskmanager.model.data.storage.prefs.CommonsPrefs
import com.weber.yakow.taskmanager.model.data.storage.prefs.PrefsImpl
import com.weber.yakow.taskmanager.system.ResourceManager
import com.weber.yakow.taskmanager.system.message.SystemMessageNotifier
import com.weber.yakow.taskmanager.system.shceduler.AppScheduler
import com.weber.yakow.taskmanager.system.shceduler.SchedulersProvider
import com.weber.yakow.taskmanager.toothpick.provider.DatabaseProvider
import com.weber.yakow.taskmanager.toothpick.provider.PersonContentDaoProvider
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber
import toothpick.config.Module

/**
 * Created on 10.12.18
 * @author YWeber
 * project BusinessCart */

class AppModule(context: Context) : Module() {
    init {
        Timber.d("init app module")
        bind(Context::class.java).toInstance(context)
        bind(ResourceManager::class.java).toInstance(ResourceManager(context))
        bind(SystemMessageNotifier::class.java).toInstance(SystemMessageNotifier())
        bind(SchedulersProvider::class.java).toInstance(AppScheduler())
        bind(CommonsPrefs::class.java).to(PrefsImpl::class.java).singletonInScope()
        Timber.d("Database init")
        bind(AppDatabase::class.java).toProvider(DatabaseProvider::class.java).providesSingletonInScope()
        bind(PersonContentDao::class.java).toProvider(PersonContentDaoProvider::class.java).providesSingletonInScope()
        // navigation
        Timber.d("Navigation init")
        val cicerone = Cicerone.create()
        bind(Router::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)
    }
}
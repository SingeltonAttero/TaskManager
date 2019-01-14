package com.weber.yakow.taskmanager

import android.app.Application
import com.weber.yakow.taskmanager.toothpick.DI
import com.weber.yakow.taskmanager.toothpick.module.AppModule
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

/**
 * Created on 09.01.19
 * @author YWeber
 * project TaskManager */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
        initToothpick()
        initScope()
    }

    private fun initScope() {
        Toothpick.openScope(DI.APP_SCOPE).installModules(AppModule(this))
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
            FactoryRegistryLocator.setRootRegistry(com.weber.yakow.taskmanager.FactoryRegistry())
            MemberInjectorRegistryLocator.setRootRegistry(com.weber.yakow.taskmanager.MemberInjectorRegistry())
        }
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
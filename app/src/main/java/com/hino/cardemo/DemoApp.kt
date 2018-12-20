package com.hino.cardemo

import android.app.Application
import com.hino.cardemo.di.AppComponent
import com.hino.cardemo.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

/**
 * @author Hien Ngo
 * @since 15/12/18
 */
class DemoApp : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DemoApp> {
        return DaggerAppComponent.builder().create(this)
    }
}
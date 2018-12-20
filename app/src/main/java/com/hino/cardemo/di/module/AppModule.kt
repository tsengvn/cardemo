package com.hino.cardemo.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * @author Hien Ngo
 * @since 16/12/18
 */
@Module
class AppModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }
}
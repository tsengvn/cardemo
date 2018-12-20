package com.hino.cardemo.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.hino.cardemo.data.repository.DataRepository
import com.hino.cardemo.data.service.CarApiService
import com.hino.cardemo.di.annotation.ApplicationScope
import com.tsengvn.redmartdemo.di.module.NetworkModule
import dagger.Module
import dagger.Provides

/**
 * @author Hien Ngo
 * @since 16/12/18
 */
@Module(includes = [NetworkModule::class])
class AppModule {

    @Provides
    @ApplicationScope
    fun provideContext(application: Application) : Context {
        return application
    }

    @Provides
    @ApplicationScope
    fun provideSharedPreference(context: Context) : SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @ApplicationScope
    @Provides
    fun dataRepository(carApi : CarApiService) : DataRepository {
        return DataRepository(carApi)
    }
}
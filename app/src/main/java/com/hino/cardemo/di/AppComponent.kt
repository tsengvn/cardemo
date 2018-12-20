package com.hino.cardemo.di

import com.hino.cardemo.di.module.AppModule
import com.hino.cardemo.ui.list.ListActivity
import com.tsengvn.redmartdemo.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Hien Ngo
 * @since 15/12/18
 */
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(listActivity: ListActivity)
}
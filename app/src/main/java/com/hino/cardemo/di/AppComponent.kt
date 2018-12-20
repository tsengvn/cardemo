package com.hino.cardemo.di

import android.app.Application
import com.hino.cardemo.DemoApp
import com.hino.cardemo.di.annotation.ApplicationScope
import com.hino.cardemo.di.module.ActivityModule
import com.hino.cardemo.di.module.AppModule
import com.hino.cardemo.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author Hien Ngo
 * @since 15/12/18
 */
@ApplicationScope
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ViewModelModule::class,
    ActivityModule::class])
interface AppComponent : AndroidInjector<DemoApp> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<DemoApp>()
}
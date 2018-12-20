package com.hino.cardemo.di.module

import com.hino.cardemo.di.annotation.ActivityScope
import com.hino.cardemo.ui.MainActivity
import com.hino.cardemo.ui.list.ListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Hien Ngo
 * @since 12/18/18
 */
@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun listActivity(): ListActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}
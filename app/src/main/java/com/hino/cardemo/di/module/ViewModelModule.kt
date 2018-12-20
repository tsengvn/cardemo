package com.hino.cardemo.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.hino.cardemo.base.ViewModelFactory
import com.hino.cardemo.di.annotation.ActivityScope
import com.hino.cardemo.di.annotation.ViewModelKey
import com.hino.cardemo.ui.list.ListItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Hien Ngo
 * @since 12/18/18
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListItemViewModel::class)
    abstract fun bindMainViewModel(viewModel: ListItemViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
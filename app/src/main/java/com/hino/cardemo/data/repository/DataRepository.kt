package com.hino.cardemo.data.repository

import android.arch.paging.DataSource
import android.arch.paging.ItemKeyedDataSource
import android.arch.paging.PagedList
import com.hino.cardemo.data.model.DataType
import com.hino.cardemo.data.model.ItemData
import com.hino.cardemo.data.model.Response
import com.hino.cardemo.data.service.CarApiService
import com.hino.cardemo.di.annotation.ActivityScope
import com.hino.cardemo.di.annotation.ApplicationScope
import com.hino.cardemo.ext.into
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Hien Ngo
 * @since 12/18/18
 */

abstract class DataRepository{
    internal val waKey = "coding-puzzle-client-449cc9d"
    val pageSize = 15
    var currentPage = 0
    val compositeDisposable = CompositeDisposable()

    abstract fun getDataSource(): DataSource.Factory<Int, ItemData>

    fun clear() {
        compositeDisposable.dispose()
    }

}
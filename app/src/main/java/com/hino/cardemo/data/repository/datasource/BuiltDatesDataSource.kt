package com.hino.cardemo.data.repository.datasource

import android.arch.paging.DataSource
import android.arch.paging.ItemKeyedDataSource
import com.hino.cardemo.data.model.DataType
import com.hino.cardemo.data.model.ItemData
import com.hino.cardemo.data.model.Response
import com.hino.cardemo.data.service.CarApiService
import com.hino.cardemo.ext.into
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * @author Hien Ngo
 * @since 20/12/18
 */
internal class BuiltDatesDataSource(val carApiService: CarApiService, val manufacturer: String, val type: String) : DataSource.Factory<Int, ItemData>() {
    private val compositeDisposable = CompositeDisposable()

    override fun create(): DataSource<Int, ItemData> {
        return object : ItemKeyedDataSource<Int, ItemData>() {
            override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<ItemData>) {
                carApiService.getBuildDate(manufacturer, type)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { callback.onResult(mapData(it)) },
                        { }
                    )
                    .into(compositeDisposable)
            }

            override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<ItemData>) {
            }

            override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<ItemData>) {
            }

            override fun getKey(item: ItemData): Int {
                return item.hashCode()
            }
        }
    }


    private fun mapData(response: Response<Map<String, String>>?): MutableList<ItemData> {
        val result = mutableListOf<ItemData>()
        response?.data?.apply {
            keys.forEach {
                val title = this.getValue(it)
                result.add(ItemData(title, it, DataType.Build))
            }
        }
        return result
    }
}
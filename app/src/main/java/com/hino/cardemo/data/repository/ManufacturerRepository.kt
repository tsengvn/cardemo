package com.hino.cardemo.data.repository

import android.arch.paging.DataSource
import android.arch.paging.ItemKeyedDataSource
import com.hino.cardemo.data.model.DataType
import com.hino.cardemo.data.model.ItemData
import com.hino.cardemo.data.model.Response
import com.hino.cardemo.data.service.CarApiService
import com.hino.cardemo.ext.into
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Hien Ngo
 * @since 20/12/18
 */
class ManufacturerRepository @Inject constructor(val carApiService: CarApiService) : DataRepository() {
    override fun getDataSource():  DataSource.Factory<Int, ItemData> {
        return object : DataSource.Factory<Int, ItemData>() {
            override fun create(): DataSource<Int, ItemData> {
                return object : ItemKeyedDataSource<Int, ItemData>() {
                    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<ItemData>) {
                        loadData(callback)
                    }

                    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<ItemData>) {
                        loadData(callback)
                    }

                    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<ItemData>) {
                        //nothing
                    }

                    override fun getKey(item: ItemData): Int {
                        return item.hashCode()
                    }
                }
            }
        }

    }

    private fun loadData(callback: ItemKeyedDataSource.LoadCallback<ItemData>) {
        carApiService.getManufacturer(waKey, currentPage++, pageSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { callback.onResult(mapData(it)) },
                {  }
            )
            .into(compositeDisposable)
    }

    private fun mapData(response: Response<Map<String, String>>?): MutableList<ItemData> {
        val result = mutableListOf<ItemData>()
        response?.data?.apply {
            keys.forEach {
                val title = this.getValue(it)
                result.add(ItemData(title, it, DataType.Manufacturer))
            }
        }
        return result
    }
}
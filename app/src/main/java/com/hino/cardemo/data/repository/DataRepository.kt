package com.hino.cardemo.data.repository

import android.arch.paging.DataSource
import com.hino.cardemo.data.model.DataType
import com.hino.cardemo.data.model.DataType.*
import com.hino.cardemo.data.model.ItemData
import com.hino.cardemo.data.repository.datasource.BuiltDatesDataSource
import com.hino.cardemo.data.repository.datasource.MainTypeDataSource
import com.hino.cardemo.data.repository.datasource.ManufacturerDataSource
import com.hino.cardemo.data.service.CarApiService
import java.lang.IllegalArgumentException

/**
 * @author Hien Ngo
 * @since 12/18/18
 */

class DataRepository(val carApiService: CarApiService) {
    private val savedData = mutableMapOf<DataType, ItemData>()
    val pageSize = 15


    fun getDataSource(screenType: DataType?): DataSource.Factory<Int, ItemData> {
        return when (screenType) {
            Manufacturer -> ManufacturerDataSource(carApiService, pageSize)
            Type -> MainTypeDataSource(carApiService, pageSize, savedData[Manufacturer]!!.description)
            Build -> BuiltDatesDataSource(carApiService, savedData[Manufacturer]!!.description, savedData[Type]!!.description)
            null -> throw IllegalArgumentException()
        }
    }

    fun save(screenType: DataType, itemData: ItemData) {
        savedData[screenType] = itemData
    }

    fun getManufacturer() : String {
        return savedData[Manufacturer]?.title ?: ""
    }

    fun getType() : String {
        return savedData[Type]?.title ?: ""
    }

    fun getBuild() : String {
        return savedData[Build]?.title ?: ""
    }

}
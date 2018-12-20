package com.hino.cardemo.ui.list

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.content.Context
import com.hino.cardemo.base.BaseViewModel
import com.hino.cardemo.data.model.DataType
import com.hino.cardemo.data.model.ItemData
import com.hino.cardemo.data.repository.DataRepository
import com.hino.cardemo.ui.Navigator
import javax.inject.Inject

/**
 * @author Hien Ngo
 * @since 12/18/18
 */

class ListItemViewModel @Inject constructor(private val dataRepository: DataRepository) : BaseViewModel() {
    var screenType : DataType? = null
    val adapter = ItemDataAdapter()

    val clickListener = object : OnItemClickedListener {
        override fun onClicked(context: Context, itemData: ItemData) {
            screenType?.apply {
                when (this) {
                    DataType.Manufacturer -> Navigator.openType(context)
                    DataType.Type -> Navigator.openBuildDate(context)
                    DataType.Build -> Navigator.openResult(context)
                }
                dataRepository.save(this, itemData)
            }
        }
    }

    fun getPagingDataList() : LiveData<PagedList<ItemData>>  {
        return LivePagedListBuilder(dataRepository.getDataSource(screenType), dataRepository.pageSize).build()
    }
}
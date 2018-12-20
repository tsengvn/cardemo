package com.hino.cardemo.ui.list

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.content.Context
import android.support.v7.widget.RecyclerView
import com.hino.cardemo.base.BaseViewModel
import com.hino.cardemo.data.model.ItemData
import com.hino.cardemo.data.repository.DataRepository
import com.hino.cardemo.ui.MyItemDecoration
import com.hino.cardemo.ui.Navigator
import javax.inject.Inject

/**
 * @author Hien Ngo
 * @since 12/18/18
 */

class ListItemViewModel @Inject constructor(private val dataRepository: DataRepository) : BaseViewModel() {
    var screenType : ScreenType? = null
    val adapter = ItemDataAdapter()
    val pagingDataList: LiveData<PagedList<ItemData>> = LivePagedListBuilder(dataRepository.getDataSource(), dataRepository.pageSize).build()
    val itemDecoration = MyItemDecoration()

    override fun onCleared() {
        super.onCleared()
        dataRepository.clear()
    }

    val clickListener = object : OnItemClickedListener {
        override fun onClicked(context: Context, itemData: ItemData) {
            when (screenType) {
                ScreenType.Manufacturer -> Navigator.openType(context, itemData.description)
                ScreenType.Type -> TODO()
                ScreenType.Build -> TODO()
            }
        }
    }
}
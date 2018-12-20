package com.hino.cardemo.base

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.hino.cardemo.data.model.ItemData

/**
 * @author Hien Ngo
 * @since 12/18/18
 */

class ItemViewModel : BaseViewModel() {
    val title = MutableLiveData<String>()
    val desc = MutableLiveData<String>()


    fun bind(itemData: ItemData) {
        title.value = itemData.title
        desc.value = itemData.description
    }

}
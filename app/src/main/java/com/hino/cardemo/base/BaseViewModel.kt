package com.hino.cardemo.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Hien Ngo
 * @since 16/12/18
 */
open class BaseViewModel: ViewModel() {

    val loader: MutableLiveData<Boolean> = MutableLiveData()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
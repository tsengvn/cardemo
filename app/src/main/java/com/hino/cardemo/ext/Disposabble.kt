package com.hino.cardemo.ext

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Hien Ngo
 * @since 20/12/18
 */
fun Disposable.into(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

package com.hino.cardemo.ext

import android.content.ContextWrapper
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * @author Hien Ngo
 * @since 20/12/18
 */
fun View.getActivity(): AppCompatActivity? {
    var context = context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}

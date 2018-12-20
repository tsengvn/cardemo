package com.hino.cardemo.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.hino.cardemo.ui.list.ListActivity
import com.hino.cardemo.ui.list.ScreenType

/**
 * @author Hien Ngo
 * @since 20/12/18
 */
object Navigator {
    fun openManufaturer(context: Context) {
        val intent = Intent(context, ListActivity::class.java)
        intent.putExtra("type", ScreenType.Manufacturer)
        context.startActivity(intent)
    }

    fun openType(context: Context, manufacturer : String) {
        val intent = Intent(context, ListActivity::class.java)
        intent.putExtra("type", ScreenType.Type)
        intent.putExtra("manufacturer", manufacturer)
        context.startActivity(intent)
    }

    fun openBuildDate(context: Context, manufacturer: Int, type: Int) {
        val intent = Intent(context, ListActivity::class.java)
        intent.putExtra("type", ScreenType.Build)
        intent.putExtra("manufacturer", manufacturer)
        intent.putExtra("type", manufacturer)
        context.startActivity(intent)
    }

    fun openResult(activity: Activity) {
//        val intent = Intent(activity, ListActivity::class.java)
//
//        activity.startActivity(intent)
    }
}
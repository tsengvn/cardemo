package com.hino.cardemo.ui

import android.content.Context
import android.content.Intent
import com.hino.cardemo.data.model.DataType
import com.hino.cardemo.ui.list.ListActivity

/**
 * @author Hien Ngo
 * @since 20/12/18
 */
object Navigator {
    fun openManufaturer(context: Context) {
        val intent = Intent(context, ListActivity::class.java)
        intent.putExtra("type", DataType.Manufacturer)
        context.startActivity(intent)
    }

    fun openType(context: Context) {
        val intent = Intent(context, ListActivity::class.java)
        intent.putExtra("type", DataType.Type)
        context.startActivity(intent)
    }

    fun openBuildDate(context: Context) {
        val intent = Intent(context, ListActivity::class.java)
        intent.putExtra("type", DataType.Build)
        context.startActivity(intent)
    }

    fun openResult(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
}
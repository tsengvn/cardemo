package com.hino.cardemo.ui

import android.graphics.Canvas
import android.graphics.Color
import android.support.v7.widget.RecyclerView

/**
 * @author Hien Ngo
 * @since 20/12/18
 */
class MyItemDecoration : RecyclerView.ItemDecoration() {
    override fun onDraw(canvas: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        canvas?.apply {
            save()
            parent?.apply {
                for (i in 0 until childCount) {
                    getChildAt(i).apply {
                        val bgColor = if (i % 2 == 0) {
                            Color.GRAY
                        } else {
                            Color.WHITE
                        }
                        setBackgroundColor(bgColor)
                    }
                }
            }
            restore()
        }
    }
}
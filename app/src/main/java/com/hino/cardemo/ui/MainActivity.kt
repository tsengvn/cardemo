package com.hino.cardemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.hino.cardemo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    fun initView() {
        val viewPager = ViewPager(this)
        setContentView(viewPager)
    }

}

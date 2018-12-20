package com.hino.cardemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hino.cardemo.DemoApp
import com.hino.cardemo.di.AppComponent

/**
 * @author Hien Ngo
 * @since 16/12/18
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(appComponent())

    }

    fun appComponent() : AppComponent {
        return (application as DemoApp).appComponent
    }

    abstract fun inject(appComponent: AppComponent)
}
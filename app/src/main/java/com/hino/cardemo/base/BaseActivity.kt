package com.hino.cardemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hino.cardemo.DemoApp
import com.hino.cardemo.di.AppComponent
import dagger.android.support.DaggerAppCompatActivity

/**
 * @author Hien Ngo
 * @since 16/12/18
 */
abstract class BaseActivity : DaggerAppCompatActivity() {
}
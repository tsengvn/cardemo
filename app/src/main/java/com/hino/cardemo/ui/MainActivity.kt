package com.hino.cardemo.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.Button
import com.hino.cardemo.R
import com.hino.cardemo.base.BaseActivity
import com.hino.cardemo.data.repository.DataRepository
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var dataRepository: DataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { Navigator.openManufaturer(this) }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        bindData()
    }

    private fun bindData() {
        tvResult.text = StringBuilder()
            .append("Manufacturer: ${dataRepository.getManufacturer()}")
            .append("\n")
            .append("Type: ${dataRepository.getType()}")
            .append("\n")
            .append("Build: ${dataRepository.getBuild()}")
            .toString()
    }

}

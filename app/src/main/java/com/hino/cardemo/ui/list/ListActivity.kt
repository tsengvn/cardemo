package com.hino.cardemo.ui.list

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.hino.cardemo.R
import com.hino.cardemo.base.BaseActivity
import com.hino.cardemo.databinding.ActivityListBinding
import com.hino.cardemo.di.AppComponent
import javax.inject.Inject

/**
 * @author Hien Ngo
 * @since 12/18/18
 */

class ListActivity : BaseActivity() {
//    @Inject
//    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var listItemViewModel: ListItemViewModel

    lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(ListItemViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        binding.viewModel = ViewModelProviders.of(this).get(ListItemViewModel::class.java)


//        binding.viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListItemViewModel::class.java).apply {
//            intent?.getSerializableExtra("type")?.apply {
//                screenType = this as? ScreenType
//            }
//        }
    }

    override fun inject(appComponent: AppComponent) {
        appComponent.inject(this)
    }
}
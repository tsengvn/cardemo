package com.hino.cardemo.ui.list

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.hino.cardemo.R
import com.hino.cardemo.base.BaseActivity
import com.hino.cardemo.base.ViewModelFactory
import com.hino.cardemo.data.model.DataType
import com.hino.cardemo.databinding.ActivityListBinding
import javax.inject.Inject

/**
 * @author Hien Ngo
 * @since 12/18/18
 */

class ListActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListItemViewModel::class.java).apply {
            intent?.getSerializableExtra("type")?.apply {
                screenType = this as? DataType
            }
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        binding.viewModel = viewModel

    }

}
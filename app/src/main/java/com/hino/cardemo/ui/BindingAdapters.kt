package com.hino.cardemo.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.hino.cardemo.ext.getActivity
import com.hino.cardemo.ui.list.ItemDataAdapter
import com.hino.cardemo.ui.list.OnItemClickedListener


/**
 * @author Hien Ngo
 * @since 12/18/18
 */
@BindingAdapter("adapter")
fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.adapter = adapter
}

@BindingAdapter("pagedDataList")
fun <T> setPagedData(recyclerView: RecyclerView, pagedDataList: LiveData<PagedList<T>>?) {
    val parentActivity: AppCompatActivity? = recyclerView.getActivity()
    val adapter = recyclerView.adapter as? PagedListAdapter<T, in RecyclerView.ViewHolder>
    if (pagedDataList != null && parentActivity != null && adapter != null) {
        pagedDataList.observe(parentActivity, Observer { value -> adapter?.submitList(value) })

    }
}

@BindingAdapter("decoration")
fun <T> setPagedData(recyclerView: RecyclerView, decoration: RecyclerView.ItemDecoration) {
    recyclerView.addItemDecoration(decoration)
}

@BindingAdapter("clickListener")
fun <T> setClickListener(recyclerView: RecyclerView, clickedListener: OnItemClickedListener) {
    val adapter = recyclerView.adapter
    if (adapter is ItemDataAdapter) {
        adapter.listener = clickedListener
    }
}
package com.hino.cardemo.ui.list

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hino.cardemo.R
import com.hino.cardemo.base.ItemViewModel
import com.hino.cardemo.data.model.ItemData
import com.hino.cardemo.databinding.ViewItemBinding

/**
 * @author Hien Ngo
 * @since 12/18/18
 */
class ItemDataAdapter : PagedListAdapter<ItemData, ItemDataAdapter.ItemViewHolder>(DIFF_CALLBACK) {
    var listener : OnItemClickedListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding : ViewItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.view_item, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemData = getItem(position)
        if (itemData != null) {
            holder.bind(itemData)
            holder.itemView.setOnClickListener { it ->  listener?.onClicked(it.context, itemData) }
        }
    }

    class ItemViewHolder(private val binding : ViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = ItemViewModel()
        fun bind(itemData: ItemData) {
            val bgColor = if (adapterPosition % 2 == 0) {
                Color.GRAY
            } else {
                Color.WHITE
            }
            itemView.setBackgroundColor(bgColor)

            viewModel.bind(itemData)
            binding.viewModel = viewModel
        }
    }
}

interface OnItemClickedListener {
    fun onClicked(context: Context, itemData: ItemData)
}

val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ItemData>() {
    override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData): Boolean = oldItem == newItem
}
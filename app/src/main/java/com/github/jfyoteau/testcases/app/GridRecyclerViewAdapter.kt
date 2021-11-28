package com.github.jfyoteau.testcases.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.jfyoteau.testcases.app.databinding.CellItemBinding

class GridRecyclerViewAdapter(
    private val onDeleteAction: OnActionListener<Item>
) : ListAdapter<Item, GridRecyclerViewAdapter.ItemViewHolder>(ItemDiff()) {

    class ItemViewHolder(val binding: CellItemBinding) : RecyclerView.ViewHolder(binding.root)

    class ItemDiff : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CellItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {
            imageView.setImageResource(item.image)

            deleteButton.setOnClickListener {
                onDeleteAction.onAction(item, position)
            }
        }
    }
}

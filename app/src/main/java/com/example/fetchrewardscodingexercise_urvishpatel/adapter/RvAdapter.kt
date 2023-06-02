package com.example.fetchrewardscodingexercise_urvishpatel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.fetchrewardscodingexercise_urvishpatel.R
import com.example.fetchrewardscodingexercise_urvishpatel.data.DataResponseItem
import com.example.fetchrewardscodingexercise_urvishpatel.databinding.ItemViewHolderBinding

class RvAdapter(val list:List<DataResponseItem>):RecyclerView.Adapter<RvAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding:ItemViewHolderBinding):ViewHolder(binding.root)
    {
        fun bind(dataResponseItem: DataResponseItem) {
            binding.data = dataResponseItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding :ItemViewHolderBinding = DataBindingUtil.inflate(inflater, R.layout.item_view_holder,parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
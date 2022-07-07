package com.example.viewtypesdatalist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.viewtypesdatalist.databinding.ItemBinding

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list = ArrayList<Data>()

    companion object {
        const val VIEW_TYPE_ONE = 0
        const val VIEW_TYPE_TWO = 1
    }

    fun addList(data: List<Data>) {
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ONE) {
            return MainViewHolder(
                ItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            return Main2ViewHolder(
                ItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position].theView == VIEW_TYPE_ONE) {
            (holder as MainViewHolder).bind(position)
        } else {
            (holder as Main2ViewHolder).bind(position)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = list[position].theView

    inner class MainViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val recyclerData = list[position]
            binding.text.text = recyclerData.theText
        }
    }

    inner class Main2ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            if (position == 1){
                val recyclerData = list[position]
                binding.text.text = recyclerData.theText
            }else{
                binding.text.visibility = View.GONE
            }
        }
    }
}


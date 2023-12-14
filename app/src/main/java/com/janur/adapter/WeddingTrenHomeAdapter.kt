package com.janur.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.janur.R
import com.janur.model.WeddingTrenHomeModel

class WeddingTrenHomeAdapter : ListAdapter<WeddingTrenHomeModel, WeddingTrenHomeAdapter.WeddingTrenViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeddingTrenViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_tren, parent, false)
        return WeddingTrenViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeddingTrenViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
    }

    inner class WeddingTrenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weddingTren: WeddingTrenHomeModel) {
            // Bind data ke tampilan item
            itemView.findViewById<TextView>(R.id.tvJudulTren).text = weddingTren.name
            itemView.findViewById<ImageView>(R.id.ivTrenWedding).setImageResource(weddingTren.icon)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<WeddingTrenHomeModel>() {
        override fun areItemsTheSame(oldItem: WeddingTrenHomeModel, newItem: WeddingTrenHomeModel): Boolean {
            return oldItem.name == newItem.name // Ganti dengan unique identifier jika ada
        }

        override fun areContentsTheSame(oldItem: WeddingTrenHomeModel, newItem: WeddingTrenHomeModel): Boolean {
            return oldItem == newItem
        }
    }
}

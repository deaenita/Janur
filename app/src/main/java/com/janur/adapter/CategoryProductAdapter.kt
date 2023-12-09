package com.janur.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.janur.R
import com.janur.model.CategoryProductModel

class CategoryProductAdapter : ListAdapter<CategoryProductModel, CategoryProductAdapter.CategoryViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_product, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: CategoryProductModel) {
            // Bind data ke tampilan item
            itemView.findViewById<TextView>(R.id.categoryName).text = category.name
            itemView.findViewById<ImageView>(R.id.categoryIcon).setImageResource(category.icon)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<CategoryProductModel>() {
        override fun areItemsTheSame(oldItem: CategoryProductModel, newItem: CategoryProductModel): Boolean {
            return oldItem.name == newItem.name // Ganti dengan unique identifier jika ada
        }

        override fun areContentsTheSame(oldItem: CategoryProductModel, newItem: CategoryProductModel): Boolean {
            return oldItem == newItem
        }
    }
}

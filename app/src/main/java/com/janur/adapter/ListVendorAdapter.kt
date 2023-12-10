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
import com.janur.model.ListVendorModel

class ListVendorAdapter : ListAdapter<ListVendorModel, ListVendorAdapter.CategoryViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_vendor, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(listVendor: ListVendorModel) {
            // Bind data ke tampilan item
            itemView.findViewById<TextView>(R.id.vendorName).text = listVendor.vendor_name
            itemView.findViewById<TextView>(R.id.vendorCity).text = listVendor.city
            itemView.findViewById<ImageView>(R.id.ivVendor).setImageResource(listVendor.image_vendor)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<ListVendorModel>() {
        override fun areItemsTheSame(oldItem: ListVendorModel, newItem: ListVendorModel): Boolean {
            return oldItem.vendor_name == newItem.vendor_name // Ganti dengan unique identifier jika ada
        }

        override fun areContentsTheSame(oldItem: ListVendorModel, newItem: ListVendorModel): Boolean {
            return oldItem == newItem
        }
    }
}

package com.janur.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.janur.R
import androidx.recyclerview.widget.DiffUtil
import com.janur.model.VendorPopulerHomeModel

class VendorPopulerHomeAdapter : ListAdapter<VendorPopulerHomeModel, VendorPopulerHomeAdapter.VendorPopulerViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorPopulerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vendor_populer, parent, false)
        return VendorPopulerViewHolder(view)
    }

    override fun onBindViewHolder(holder: VendorPopulerViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
    }

    inner class VendorPopulerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(populerVendor: VendorPopulerHomeModel) {
            // Bind data ke tampilan item
            itemView.findViewById<ImageView>(R.id.ivVendorPopuler).setImageResource(populerVendor.icon)
            itemView.findViewById<TextView>(R.id.tvNamaVendorPopuler).text = populerVendor.namevendor
            itemView.findViewById<TextView>(R.id.tvNamaLayananPopuler).text = populerVendor.namelayanan
            itemView.findViewById<TextView>(R.id.tvJumlahBookingPopuler).text = populerVendor.jumlahbooking
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<VendorPopulerHomeModel>() {
        override fun areItemsTheSame(oldItem: VendorPopulerHomeModel, newItem: VendorPopulerHomeModel): Boolean {
            return oldItem.namevendor == newItem.namevendor // Ganti dengan unique identifier jika ada
        }

        override fun areContentsTheSame(oldItem: VendorPopulerHomeModel, newItem: VendorPopulerHomeModel): Boolean {
            return oldItem == newItem
        }
    }
}

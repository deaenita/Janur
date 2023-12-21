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
import com.janur.model.CategoryProductModel
import com.janur.model.PesananDalamProsesModel

class PesananDalamProsesAdapter : ListAdapter<PesananDalamProsesModel, PesananDalamProsesAdapter.PesananViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesananViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pesanan_dalam_proses, parent, false)
        return PesananViewHolder(view)
    }

    override fun onBindViewHolder(holder: PesananViewHolder, position: Int) {
        val pesanan = getItem(position)
        holder.bind(pesanan)
    }

    inner class PesananViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: PesananDalamProsesModel) {
            // Bind data ke tampilan item
            itemView.findViewById<TextView>(R.id.tvNamaLayanan).text = category.name
            itemView.findViewById<ImageView>(R.id.ivIconLayanan).setImageResource(category.icon)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<PesananDalamProsesModel>() {
        override fun areItemsTheSame(oldItem: PesananDalamProsesModel, newItem: PesananDalamProsesModel): Boolean {
            return oldItem.name == newItem.name // Ganti dengan unique identifier jika ada
        }

        override fun areContentsTheSame(oldItem: PesananDalamProsesModel, newItem: PesananDalamProsesModel): Boolean {
            return oldItem == newItem
        }
    }
}

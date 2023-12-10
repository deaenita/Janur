package com.janur.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.janur.R
import com.janur.model.ListVendorModel

class ListVendorViewModel : ViewModel() {
    private val categories = MutableLiveData<List<ListVendorModel>>()

    // Inisialisasi data kategori
    init {
        // Isi kategori dari sumber data
        val categoriesList = listOf(
            ListVendorModel("Noka",R.drawable.baseline_android_24, "Solo"),
            ListVendorModel("Liandra",R.drawable.baseline_android_24, "Salatiga"),
            ListVendorModel("Rose",R.drawable.baseline_android_24, "Salatiga"),
            ListVendorModel("Petty",R.drawable.baseline_android_24, "Salatiga"),
            ListVendorModel("Petty",R.drawable.baseline_android_24, "Salatiga"),
            ListVendorModel("Petty",R.drawable.baseline_android_24, "Salatiga"),
            ListVendorModel("Petty",R.drawable.baseline_android_24, "Salatiga"),
            ListVendorModel("Petty",R.drawable.baseline_android_24, "Salatiga"),
            // ...tambahkan kategori lainnya
        )
        categories.value = categoriesList
    }

    fun getCategories(): LiveData<List<ListVendorModel>> {
        return categories
    }
}
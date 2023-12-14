package com.janur.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.janur.R
import com.janur.model.VendorPopulerHomeModel

class VendorPopulerHomeViewModel : ViewModel() {
    private val categories = MutableLiveData<List<VendorPopulerHomeModel>>()

    // Inisialisasi data kategori
    init {
        // Isi kategori dari sumber data
        val categoriesList = listOf(
            VendorPopulerHomeModel(R.drawable.dummy_image, "Noka","Foto Video","100 booking"),
            VendorPopulerHomeModel(R.drawable.dummy_image, "Liandra","WO","101 booking"),
            VendorPopulerHomeModel(R.drawable.dummy_image, "Rose","Catering","159 booking"),
            VendorPopulerHomeModel(R.drawable.dummy_image, "Eling Bening","Vanue","120 booking"),
            VendorPopulerHomeModel(R.drawable.dummy_image, "Noka","Foto Video","100 booking"),
            // ...tambahkan kategori lainnya
        )
        categories.value = categoriesList
    }

    fun getCategories(): LiveData<List<VendorPopulerHomeModel>> {
        return categories
    }
}
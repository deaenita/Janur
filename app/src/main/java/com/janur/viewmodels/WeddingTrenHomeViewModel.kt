package com.janur.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.janur.R
import com.janur.model.WeddingTrenHomeModel

class WeddingTrenHomeViewModel : ViewModel() {
    private val categories = MutableLiveData<List<WeddingTrenHomeModel>>()

    // Inisialisasi data kategori
    init {
        // Isi kategori dari sumber data
        val categoriesList = listOf(
            WeddingTrenHomeModel(R.drawable.dummy_image, "Royal Wedding"),
            WeddingTrenHomeModel(R.drawable.dummy_image, "Intimate Wedding"),
            WeddingTrenHomeModel(R.drawable.dummy_image, "Garden Wedding"),
            WeddingTrenHomeModel(R.drawable.dummy_image, "Beach Wedding"),
            WeddingTrenHomeModel(R.drawable.dummy_image, "Ngunduh Mantu"),
            WeddingTrenHomeModel(R.drawable.dummy_image, "Muslim Wedding"),
            // ...tambahkan kategori lainnya
        )
        categories.value = categoriesList
    }

    fun getCategories(): LiveData<List<WeddingTrenHomeModel>> {
        return categories
    }
}
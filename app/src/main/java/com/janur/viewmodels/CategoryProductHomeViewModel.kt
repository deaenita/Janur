package com.janur.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.janur.R
import com.janur.model.CategoryProductHomeModel

class CategoryProductHomeViewModel : ViewModel() {
    private val categories = MutableLiveData<List<CategoryProductHomeModel>>()

    // Inisialisasi data kategori
    init {
        // Isi kategori dari sumber data
        val categoriesList = listOf(
            CategoryProductHomeModel(R.drawable.baseline_android_24, "Dekorasi"),
            CategoryProductHomeModel(R.drawable.baseline_android_24, "Wedding Organizer"),
            CategoryProductHomeModel(R.drawable.baseline_android_24, "Makeup"),
            CategoryProductHomeModel(R.drawable.baseline_android_24, "Photo Video"),
            CategoryProductHomeModel(R.drawable.baseline_android_24, "Catering"),
            CategoryProductHomeModel(R.drawable.baseline_android_24, "Lainnya"),
            // ...tambahkan kategori lainnya
        )
        categories.value = categoriesList
    }

    fun getCategories(): LiveData<List<CategoryProductHomeModel>> {
        return categories
    }
}
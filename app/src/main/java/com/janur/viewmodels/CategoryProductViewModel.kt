package com.janur.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.janur.R
import com.janur.model.CategoryProductModel

class CategoryProductViewModel : ViewModel() {
    private val categories = MutableLiveData<List<CategoryProductModel>>()

    // Inisialisasi data kategori
    init {
        // Isi kategori dari sumber data
        val categoriesList = listOf(
            CategoryProductModel(R.drawable.baseline_android_24, "Dekorasi"),
            CategoryProductModel(R.drawable.baseline_android_24, "Wedding Organizer"),
            CategoryProductModel(R.drawable.baseline_android_24, "Makeup"),
            CategoryProductModel(R.drawable.baseline_android_24, "Photo Video"),
            CategoryProductModel(R.drawable.baseline_android_24, "Catering"),
            CategoryProductModel(R.drawable.baseline_android_24, "Entertain"),
            CategoryProductModel(R.drawable.baseline_android_24, "Category 7"),
            CategoryProductModel(R.drawable.baseline_android_24, "Category 8"),
            CategoryProductModel(R.drawable.baseline_android_24, "Category 9"),
            CategoryProductModel(R.drawable.baseline_android_24, "Category 10"),
            CategoryProductModel(R.drawable.baseline_android_24, "Category 11"),
            CategoryProductModel(R.drawable.baseline_android_24, "Category 12"),
            CategoryProductModel(R.drawable.baseline_android_24, "Category 13"),
            CategoryProductModel(R.drawable.baseline_android_24, "Category 14"),
            CategoryProductModel(R.drawable.baseline_android_24, "Category 15"),
            CategoryProductModel(R.drawable.baseline_android_24, "Category 16"),
            // ...tambahkan kategori lainnya
        )
        categories.value = categoriesList
    }

    fun getCategories(): LiveData<List<CategoryProductModel>> {
        return categories
    }
}
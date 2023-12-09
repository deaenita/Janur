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
            CategoryProductModel(R.drawable.category_product_icon, "Category 1"),
            CategoryProductModel(R.drawable.category_product_icon, "Category 2"),
            // ...tambahkan kategori lainnya
        )
        categories.value = categoriesList
    }

    fun getCategories(): LiveData<List<CategoryProductModel>> {
        return categories
    }
}
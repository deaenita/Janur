package com.janur.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.janur.R
import com.janur.model.PesananDalamProsesModel

class PesananDalamProsesViewModel : ViewModel() {
    private val pesanans = MutableLiveData<List<PesananDalamProsesModel>>()

    init {
        val pesananList = listOf(
            PesananDalamProsesModel(R.drawable.baseline_android_24, "Dekorasi"),
            PesananDalamProsesModel(R.drawable.baseline_android_24, "Wedding Organizer"),
            PesananDalamProsesModel(R.drawable.baseline_android_24, "Makeup"),
            PesananDalamProsesModel(R.drawable.baseline_android_24, "Photo Video"),
            PesananDalamProsesModel(R.drawable.baseline_android_24, "Catering"),
            PesananDalamProsesModel(R.drawable.baseline_android_24, "Entertain"),
            // ...tambahkan kategori lainnya
        )
        pesanans.value = pesananList
    }

    fun getPesanan(): LiveData<List<PesananDalamProsesModel>> {
        return pesanans
    }
}
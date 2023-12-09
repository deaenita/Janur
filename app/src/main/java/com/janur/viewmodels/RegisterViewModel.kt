package com.janur.viewmodels

import androidx.lifecycle.ViewModel
import com.janur.model.RegisterModel

class RegisterViewModel : ViewModel() {
    // Fungsi untuk melakukan pendaftaran user
    fun registerUser(user: RegisterModel) {
        // Di sini Anda dapat menambahkan logika untuk menyimpan data pengguna, misalnya ke database atau backend server
        // Contoh sederhana, hanya mencetak informasi pengguna yang didaftarkan
        println("Registering user: ${user.username}, ${user.email}, ${user.password}")
    }
}
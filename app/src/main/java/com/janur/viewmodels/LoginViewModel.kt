package com.janur.viewmodels

import androidx.lifecycle.ViewModel
import com.janur.model.LoginModel

class LoginViewModel : ViewModel()  {
    fun loginUser(user: LoginModel) {
        // Di sini Anda dapat menambahkan logika untuk menyimpan data pengguna, misalnya ke database atau backend server
        // Contoh sederhana, hanya mencetak informasi pengguna yang didaftarkan
        println("Login user: ${user.email_username}, ${user.password}")
    }
}
package com.janur.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.janur.R

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomepageFragment())
                .commit()
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomepageFragment())
                        .commit()
                    true
                }
                R.id.navigation_pesanan -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, PesananFragment())
                        .commit()
                    true
                }

                R.id.navigation_akun -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, AkunFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
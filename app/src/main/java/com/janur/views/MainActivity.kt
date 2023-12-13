package com.janur.views

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.janur.R

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmant_home, CategoryProductFragment())
                        .commit()
                    true
                }
                R.id.navigation_pesanan -> {
                    val pesananFragment = PesananFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, pesananFragment)
                        .commit()
                    true
                }

                R.id.navigation_akun -> {
                    val akunFragment = AkunFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, akunFragment)
                        .commit()
                    true
                }

                else -> false
            }
        }


        // Add animation when BottomNavigationView item is selected
        bottomNavigationView.itemIconTintList = null
        bottomNavigationView.setOnItemSelectedListener(object :
            NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                val drawable = item.icon ?: return false // Menambahkan pengecekan null pada item.icon
                val currentRadius = (drawable.intrinsicWidth / 2).toFloat() // Mengonversi hasil pembagian ke Float
                val finalRadius = currentRadius * 1.5f

                val animator = ValueAnimator.ofFloat(currentRadius, finalRadius)
                animator.addUpdateListener { animation ->
                    val scale = animation.animatedValue as Float
                    drawable.setBounds(
                        0,
                        0,
                        (scale * drawable.intrinsicWidth).toInt(),
                        (scale * drawable.intrinsicHeight).toInt()
                    )
                    item.icon = drawable
                }
                animator.duration = 200
                animator.start()
                return true
            }
        })



        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomepageFragment())
                .commit()
        }
//
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, ListVendorFragment())
//                .commit()
//        }


    }
}
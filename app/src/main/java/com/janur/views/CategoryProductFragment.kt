package com.janur.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.janur.R
import com.janur.adapter.CategoryProductAdapter
import com.janur.viewmodels.CategoryProductViewModel

class CategoryProductFragment : Fragment() {

    private lateinit var categoryViewModel: CategoryProductViewModel
    private lateinit var categoryAdapter: CategoryProductAdapter // Buat adapter sesuai kebutuhanmu


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_category_product, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        categoryAdapter = CategoryProductAdapter() // Sesuaikan dengan adapter yang kamu buat
        recyclerView.adapter = categoryAdapter

        // Inisialisasi ViewModel
        categoryViewModel = ViewModelProvider(this).get(CategoryProductViewModel::class.java)
        categoryViewModel.getCategories().observe(viewLifecycleOwner, { categories ->
            // Update data ke adapter saat data berubah
            categoryAdapter.submitList(categories)
        })

        return root
    }

    companion object {}

}
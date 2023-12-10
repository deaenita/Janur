package com.janur.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.janur.R
import com.janur.adapter.CategoryProductAdapter
import com.janur.viewmodels.CategoryProductViewModel

class CategoryProductFragment : Fragment() {

    private lateinit var categoryViewModel: CategoryProductViewModel

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
        val recyclerView: RecyclerView = root.findViewById(R.id.rvProductCategory)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        recyclerView.setHasFixedSize(false)

        //set adapter
        val categoryAdapter = CategoryProductAdapter() // Sesuaikan dengan adapter yang kamu buat
        recyclerView.adapter = categoryAdapter

        // Inisialisasi ViewModel
        categoryViewModel = ViewModelProvider(this).get(CategoryProductViewModel::class.java)
        categoryViewModel.getCategories().observe(viewLifecycleOwner, { categories ->
            // Update data ke adapter saat data berubah
            categoryAdapter.submitList(categories)
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        toolbar
//        val toolbar = requireView().findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarProductCategory)
//        toolbar.title = "Kategori Produk"
//        (requireActivity() as AppCompatActivity).setSupportActionBar(null)
    }
}
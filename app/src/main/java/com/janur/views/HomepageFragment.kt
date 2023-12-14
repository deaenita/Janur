package com.janur.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.janur.R
import com.janur.adapter.CategoryProductHomeAdapter
import com.janur.adapter.VendorPopulerHomeAdapter
import com.janur.adapter.WeddingTrenHomeAdapter
import com.janur.viewmodels.CategoryProductHomeViewModel
import com.janur.viewmodels.VendorPopulerHomeViewModel
import com.janur.viewmodels.WeddingTrenHomeViewModel

class HomepageFragment : Fragment() {

    private lateinit var categoryViewModel: CategoryProductHomeViewModel
    private lateinit var trenViewModel: WeddingTrenHomeViewModel
    private lateinit var populerVendorModel: VendorPopulerHomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_homepage, container, false)

        //RV Category
        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = root.findViewById(R.id.rvCategoryHome)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        recyclerView.setHasFixedSize(false)

        //set adapter
        val categoryAdapter = CategoryProductHomeAdapter() // Sesuaikan dengan adapter yang kamu buat
        recyclerView.adapter = categoryAdapter

        // Inisialisasi ViewModel
        categoryViewModel = ViewModelProvider(this).get(CategoryProductHomeViewModel::class.java)
        categoryViewModel.getCategories().observe(viewLifecycleOwner, { categories ->
            categoryAdapter.submitList(categories)
        })

        //RV Tren
        // Inisialisasi RecyclerView
        val rvWeddingTren: RecyclerView = root.findViewById(R.id.rvTrenWedding)

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvWeddingTren.layoutManager = layoutManager

        rvWeddingTren.setHasFixedSize(false)

        //set adapter
        val weddingTrenAdapter = WeddingTrenHomeAdapter() // Sesuaikan dengan adapter yang kamu buat
        rvWeddingTren.adapter = weddingTrenAdapter

        // Inisialisasi ViewModel
        trenViewModel = ViewModelProvider(this).get(WeddingTrenHomeViewModel::class.java)
        trenViewModel.getCategories().observe(viewLifecycleOwner, { trenwedding ->
            // Update data ke adapter saat data berubah
            weddingTrenAdapter.submitList(trenwedding)
        })

        //RV Vendor Populer
        // Inisialisasi RecyclerView
        val rvVendorPopuler: RecyclerView = root.findViewById(R.id.rvVendorPopuler)

        val layoutManagerVendorPopuler = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvVendorPopuler.layoutManager = layoutManagerVendorPopuler

        rvVendorPopuler.setHasFixedSize(false)

        //set adapter
        val populerVendorAdapter = VendorPopulerHomeAdapter() // Sesuaikan dengan adapter yang kamu buat
        rvVendorPopuler.adapter = populerVendorAdapter

        // Inisialisasi ViewModel
        populerVendorModel = ViewModelProvider(this).get(VendorPopulerHomeViewModel::class.java)
        populerVendorModel.getCategories().observe(viewLifecycleOwner, { populerwedding ->
            // Update data ke adapter saat data berubah
            populerVendorAdapter.submitList(populerwedding)
        })
        return root
    }
}
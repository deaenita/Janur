package com.janur.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.janur.R
import com.janur.adapter.CategoryProductAdapter
import com.janur.adapter.ListVendorAdapter
import com.janur.viewmodels.CategoryProductViewModel
import com.janur.viewmodels.ListVendorViewModel

class ListVendorFragment : Fragment() {

    private lateinit var listVendorViewModel: ListVendorViewModel

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

        val root = inflater.inflate(R.layout.fragment_list_vendor, container, false)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = root.findViewById(R.id.rvListVendor)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        recyclerView.setHasFixedSize(false)

        //set adapter
        val listProductAdapter = ListVendorAdapter() // Sesuaikan dengan adapter yang kamu buat
        recyclerView.adapter = listProductAdapter

        // Inisialisasi ViewModel
        listVendorViewModel = ViewModelProvider(this).get(ListVendorViewModel::class.java)
        listVendorViewModel.getCategories().observe(viewLifecycleOwner, { categories ->
            // Update data ke adapter saat data berubah
            listProductAdapter.submitList(categories)
        })
        return root
    }
}
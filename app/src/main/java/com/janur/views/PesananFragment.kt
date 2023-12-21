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
import com.janur.adapter.CategoryProductAdapter
import com.janur.adapter.PesananDalamProsesAdapter
import com.janur.adapter.WeddingTrenHomeAdapter
import com.janur.viewmodels.CategoryProductHomeViewModel
import com.janur.viewmodels.CategoryProductViewModel
import com.janur.viewmodels.PesananDalamProsesViewModel
import com.janur.viewmodels.WeddingTrenHomeViewModel

class PesananFragment : Fragment() {

    private lateinit var pesananDalamProsesViewModel: PesananDalamProsesViewModel

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
        val root = inflater.inflate(R.layout.fragment_pesanan, container, false)

        // Inisialisasi RecyclerView
        //RV Pesanan Saya
        // Inisialisasi RecyclerView
        val rvPesanan: RecyclerView = root.findViewById(R.id.rvListPesanan)

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvPesanan.layoutManager = layoutManager

        rvPesanan.setHasFixedSize(false)

        //set adapter
        val pesananAdapter = PesananDalamProsesAdapter()
        rvPesanan.adapter = pesananAdapter

        // Inisialisasi ViewModel
        pesananDalamProsesViewModel = ViewModelProvider(this).get(PesananDalamProsesViewModel::class.java)
        pesananDalamProsesViewModel.getPesanan().observe(viewLifecycleOwner, { pesanan ->
            // Update data ke adapter saat data berubah
            pesananAdapter.submitList(pesanan)
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
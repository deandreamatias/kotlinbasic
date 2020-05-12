package com.slashmobility.seleccion.matias.deandrea.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.slashmobility.seleccion.matias.deandrea.core.ListViewModel
import com.slashmobility.seleccion.matias.deandrea.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by lazy {
        ViewModelProviders.of(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding = FragmentListBinding.inflate(inflater)

        // Allows data binding to observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the ListViewModel
        binding.viewModel = viewModel

        binding.btnAdd.setOnClickListener {
            Log.d("ListFragment","Sou demais, mas ainda não faço nada")
        }

        return binding.root
    }
}

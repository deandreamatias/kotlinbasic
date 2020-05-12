package com.slashmobility.seleccion.matias.deandrea.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.slashmobility.seleccion.matias.deandrea.R
import com.slashmobility.seleccion.matias.deandrea.core.MainViewModel
import com.slashmobility.seleccion.matias.deandrea.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = FragmentMainBinding.inflate(inflater)

        // Allows data binding to observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to MainViewModel
        binding.viewModel = viewModel

        // Execute 'some things' when press in CALL SERVICE button
        binding.btnCallService.setOnClickListener {
            viewModel.getOrigin()
        }

        binding.btnActivityList.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_activityList)
        )

        return binding.root
    }
}
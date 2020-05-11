package com.slashmobility.seleccion.matias.deandrea.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.slashmobility.seleccion.matias.deandrea.R
import kotlinx.android.synthetic.main.fragment_activity_main.*

class MainFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnActivityList.setOnClickListener{
            findNavController().navigate(R.id.activityList)
        }
    }
}
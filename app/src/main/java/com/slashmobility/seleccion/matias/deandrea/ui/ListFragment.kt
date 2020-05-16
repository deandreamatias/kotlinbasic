package com.slashmobility.seleccion.matias.deandrea.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.slashmobility.seleccion.matias.deandrea.core.ListViewModel
import com.slashmobility.seleccion.matias.deandrea.databinding.FragmentListBinding


class ListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val viewModel: ListViewModel by lazy {
            ViewModelProviders.of(this).get(ListViewModel::class.java)
        }

        val binding = FragmentListBinding.inflate(inflater)

        // Allows data binding to observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the ListViewModel
        binding.viewModel = viewModel

        binding.list.layoutManager = LinearLayoutManager(this.activity)


        viewModel.randomValues.observe(viewLifecycleOwner, Observer {
            binding.list.adapter = ListAdapter(viewModel.randomValues.value!!)
        });

        binding.btnAdd.setOnClickListener {
            viewModel.createList(binding.fieldNumberAdd.text.toString().toInt())
        }

        binding.btnRemove.setOnClickListener {
            viewModel.clearList()
        }

        binding.btnSort.setOnClickListener {
            viewModel.orderList()
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.deleteItemList(viewHolder.adapterPosition)
            }
        }).attachToRecyclerView(binding.list)

        return binding.root

    }
}


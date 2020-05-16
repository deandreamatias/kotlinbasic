package com.slashmobility.seleccion.matias.deandrea.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.slashmobility.seleccion.matias.deandrea.R.layout


class ListAdapter (private val list: Array<Int>): RecyclerView.Adapter<TextItemViewHolder>() {

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = list[position]
        holder.textView.text = item.toString()
        if (position % 2 == 0){
            holder.textView.setBackgroundColor(Color.BLUE)
        } else {
            holder.textView.setBackgroundColor(Color.CYAN)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(layout.text_item_view, parent, false) as TextView

        return TextItemViewHolder(view)
    }

    override fun getItemCount() = list.size
}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

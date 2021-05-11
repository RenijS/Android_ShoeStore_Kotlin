package com.example.shoestore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(context: Context, private val dataset: List<Item>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(view: View): RecyclerView.ViewHolder(view){
        val row_cardView: CardView = view.findViewById(R.id.row_cardView)
        val item_title: TextView = view.findViewById(R.id.tvTitle)
        val item_price: TextView = view.findViewById(R.id.etPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row,parent,false)
        return ListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = dataset[position]

        holder.item_title.text = item.name
        holder.item_price.text = "$ ${item.price}"
        holder.row_cardView.setOnClickListener { view:View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment(position))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
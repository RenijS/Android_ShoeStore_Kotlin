package com.example.shoestore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore.databinding.RecyclerviewRowBinding
import com.example.shoestore.model.Item

class ListAdapter(private val fragment: Fragment) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var shoeList: List<Item> = listOf()
    class ListViewHolder(binding: RecyclerviewRowBinding): RecyclerView.ViewHolder(binding.root){
        val row_cardView: CardView = binding.rowCardView
        val item_title: TextView = binding.tvTitle
        val item_price: TextView = binding.etPrice
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = RecyclerviewRowBinding.inflate(LayoutInflater.from(fragment.requireContext()), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = shoeList[position]

        holder.item_title.text = item.name
        holder.item_price.text = "$ ${item.price}"
        holder.row_cardView.setOnClickListener { view:View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment(item))
        }
    }

    override fun getItemCount(): Int {
        return shoeList.size
    }

    fun shoeList(list: List<Item>){
        shoeList = list
        notifyDataSetChanged()
    }
}
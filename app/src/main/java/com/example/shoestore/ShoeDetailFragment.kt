package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.shoestore.model.Item
import com.example.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private lateinit var item: Item

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail,container, false)

        val args: ShoeDetailFragmentArgs by navArgs()

        //databinding the data, connecting List with the fragments xml.
        item = args.shoeDetails
        //binding.item refers to name = "Item" in data in the fragment's xml
        binding.item = item

        //setting app bar name
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe Detail"
        return binding.root
    }
}
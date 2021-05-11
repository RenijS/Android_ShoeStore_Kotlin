package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private var _binding: FragmentShoeDetailBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShoeDetailBinding.inflate(inflater,container, false)
        val args = ShoeDetailFragmentArgs.fromBundle(requireArguments())
        binding.tvTitleD.text = itemList[args.position].name
        binding.tvCompany.text = itemList[args.position].company
        binding.tvDesc.text = itemList[args.position].description
        binding.tvSex.text = itemList[args.position].sex
        binding.tvPrice.text = "$ ${itemList[args.position].price}"

        //setting app bar name
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe Detail"
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
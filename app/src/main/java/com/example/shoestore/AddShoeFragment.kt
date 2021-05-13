package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentAddShoeBinding

class AddShoeFragment : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_shoe,container,false)

        val etTitle = binding.etTitle
        val etDesc = binding.etDesc
        val etCompany = binding.etCompany
        val etPrice = binding.etPrice
        val etSex = binding.etSex

        binding.buttonCancel.setOnClickListener {view: View ->
            view.findNavController().navigate(AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment())
        }

        binding.buttonSave.setOnClickListener { view: View ->
            if (etTitle.text.isNullOrEmpty() || etPrice.text.isNullOrEmpty() || etDesc.text.isNullOrEmpty() || etCompany.text.isNullOrEmpty() || etSex.text.isNullOrEmpty()){
                Toast.makeText(this.requireContext(),"Enter all the details", Toast.LENGTH_LONG).show()
            } else {
                itemList.add(
                    Item(
                        etTitle.text.toString(),
                        etDesc.text.toString(),
                        etPrice.text.toString().toDouble(),
                        etCompany.text.toString(),
                        etSex.text.toString()
                    )
                )
                etTitle.text!!.clear()
                etPrice.text!!.clear()
                etCompany.text!!.clear()
                etSex.text!!.clear()
                etDesc.text!!.clear()

                Toast.makeText(this.requireContext(), "Item added", Toast.LENGTH_SHORT).show()
            }
        }

        //setting app bar name
        (activity as AppCompatActivity).supportActionBar?.title = "Add Shoe"

        return binding.root
    }

}
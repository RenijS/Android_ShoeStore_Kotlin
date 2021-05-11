package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentInstructionBinding
import com.example.shoestore.databinding.FragmentWelcomeBinding

class InstructionFragment : Fragment() {

    private var _binding : FragmentInstructionBinding? = null

    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInstructionBinding.inflate(inflater,container,false)
        binding.buttonList.setOnClickListener { view: View ->
            view.findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
        }
        //setting app bar name
        (activity as AppCompatActivity).supportActionBar?.title = "Instruction"

        return binding.root
    }


}
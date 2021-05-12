package com.example.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private var _binding: FragmentShoeListBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)
        binding.fActionBar.setOnClickListener { view:View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment())
        }

        //setting app bar name
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe List"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = ListAdapter(this.requireContext(), itemList)

    }

    //creating menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu,menu)
    }

    //when item in menu is selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.loginFragment ->
                // this navigates itself
                // the id of loginFragment in navGraph and the id of item in menu is same which helps in navigation
                NavigationUI.onNavDestinationSelected(item!!, this.findNavController())
            else -> super.onOptionsItemSelected(item)
        }
    }

}
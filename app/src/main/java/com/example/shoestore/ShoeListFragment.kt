package com.example.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoestore.application.ShoeApplication
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.viewmodel.ShoeViewModel
import com.example.shoestore.viewmodel.ShoeViewModelFactory

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private val mShoeViewModel: ShoeViewModel by viewModels{
        ShoeViewModelFactory((requireActivity().application as ShoeApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list,container, false)
        binding.fActionBar.setOnClickListener { view:View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment())
        }

        //setting app bar name
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe List"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val listAdapter = ListAdapter(this)
        binding.recyclerView.adapter = listAdapter

        mShoeViewModel.allShoeList.observe(viewLifecycleOwner){
            shoes ->
                shoes.let {
                    if (it.isNotEmpty()){
                        binding.tvNoItem.visibility = View.GONE
                        binding.recyclerView.visibility = View.VISIBLE

                        listAdapter.shoeList(it)
                    } else{
                        binding.tvNoItem.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE

                    }
                }
        }

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
                NavigationUI.onNavDestinationSelected(item, this.findNavController())
            else -> super.onOptionsItemSelected(item)
        }
    }

}
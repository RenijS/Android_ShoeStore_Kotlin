 package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)

        binding.buttonLogin.setOnClickListener { view: View ->
            if (binding.etEmail.text.isNullOrEmpty() && binding.etPassword.text.isNullOrEmpty()){
                Toast.makeText(this.requireContext(),"Enter all details",Toast.LENGTH_LONG).show()
            } else {
                view.findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
        binding.buttonSignup.setOnClickListener { view: View ->
            if (binding.etEmail.text.isNullOrEmpty() && binding.etPassword.text.isNullOrEmpty()) {
                Toast.makeText(this.requireContext(), "Enter all details", Toast.LENGTH_LONG).show()
            } else {
                view.findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }

        // editing action bar title
        (activity as AppCompatActivity).supportActionBar?.title = "Login"
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //making option menu true
        setHasOptionsMenu(true)

    }

    //To hide option menu(logout) from login fragment
    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.clear()
    }
}
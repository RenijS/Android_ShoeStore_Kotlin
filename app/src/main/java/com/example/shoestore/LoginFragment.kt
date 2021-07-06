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
import com.google.firebase.auth.FirebaseAuth

 class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false)

        binding.buttonLogin.setOnClickListener { view: View ->
            if (binding.etEmail.text.isNullOrEmpty() && binding.etPassword.text.isNullOrEmpty()){
                Toast.makeText(this.requireContext(),"Enter all details",Toast.LENGTH_LONG).show()
            }
            else {
                val email: String = binding.etEmail.text.toString().trim{ it <= ' '}
                val password: String = binding.etPassword.text.toString().trim{ it <= ' '}

                //log in using FirebaseAuth
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val firebaseUser = task.result!!.user!!
                            Toast.makeText(
                                this.requireContext(),
                                "Logged in successfully with ${firebaseUser.email}",
                                Toast.LENGTH_SHORT
                            ).show()

                            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                            } else {
                            Toast.makeText(
                                this.requireContext(),
                                task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }
        binding.buttonSignup.setOnClickListener { view: View ->
            if (binding.etEmail.text.isNullOrEmpty() && binding.etPassword.text.isNullOrEmpty()) {
                Toast.makeText(this.requireContext(), "Enter all details", Toast.LENGTH_LONG).show()
            } else {
                val email: String = binding.etEmail.text.toString().trim{ it <= ' '}
                val password: String = binding.etPassword.text.toString().trim{ it <= ' '}

                //creating instance and registering user
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val firebaseUser = task.result!!.user!!
                            Toast.makeText(
                                this.requireContext(),
                                "registered successfully with ${firebaseUser.email}",
                                Toast.LENGTH_SHORT
                            ).show()

                            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                        } else {
                            Toast.makeText(
                                this.requireContext(),
                                task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
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
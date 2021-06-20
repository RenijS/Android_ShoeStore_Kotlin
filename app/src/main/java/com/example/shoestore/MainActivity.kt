package com.example.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        WITHOUT NAV COMPONENT
//        val shoeListFragment = ShoeListFragment()
//        val loginFragment = LoginFragment()
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.main_fragment, shoeListFragment)
//            commit()
//        }

        val navController = this.findNavController(R.id.myNavHostFragment)
        /** adding action bar for activity
         * Fragment is passed into an activity so action bar on activity**/
        NavigationUI.setupActionBarWithNavController(this,navController)


    }

    //code for when back is clicked on action bar
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

}
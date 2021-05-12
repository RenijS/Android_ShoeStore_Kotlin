package com.example.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
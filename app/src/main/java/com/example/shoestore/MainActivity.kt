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

    //creating option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.logout_menu, menu)
        return true
    }

    // when item in option menu is selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.loginFragment ->
                // this navigates itself
                // the id of loginFragment in navGraph and the id of item in menu is same which helps in navigation
                NavigationUI.onNavDestinationSelected(item!!, this.findNavController(R.id.myNavHostFragment))
            else -> super.onOptionsItemSelected(item)
        }

    }
}
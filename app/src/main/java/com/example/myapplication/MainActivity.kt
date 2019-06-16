package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost = supportFragmentManager.findFragmentById(R.id.mainNavHost) as NavHostFragment
        val selectionListener = { it: MenuItem ->
            // We mirrored the navigation ids in the menu file allowing us to leave out the if statements ;)
            navHost.navController.navigate(it.itemId)
            true
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(selectionListener)

        // We need to update the bottom bar when back is pressed
        navHost.navController.addOnDestinationChangedListener { _, destination, _ ->
            bottomNavigationView.post {
                if (destination.id != bottomNavigationView.selectedItemId) {
                    bottomNavigationView.setOnNavigationItemSelectedListener { true }
                    bottomNavigationView.selectedItemId = destination.id
                    bottomNavigationView.setOnNavigationItemSelectedListener(selectionListener)
                }
            }
        }
    }

    override fun onBackPressed() {
        val navController = (supportFragmentManager.findFragmentById(R.id.mainNavHost) as NavHostFragment).navController
        if (navController.popBackStack()) {
            Log.i("MainActivity", "mainNavHost handled back event")
        } else {
            super.onBackPressed()
        }
    }
}

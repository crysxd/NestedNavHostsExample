package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost = supportFragmentManager.findFragmentById(R.id.mainNavHost) as NavHostFragment

        bottomNavigationView.setOnNavigationItemSelectedListener {
            // We mirrored the navigation ids in the menu file allowing us to leave out the if statements ;)
            navHost.navController.navigate(it.itemId)
            true
        }
    }
}

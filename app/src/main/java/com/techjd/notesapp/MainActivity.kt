package com.techjd.notesapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView

import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)

        return navController.navigateUp() || super.onSupportNavigateUp()
    }

//    override fun onBackPressed() {
//        val navigationController = findNavController(R.id.fragment)
//        when (navigationController.currentDestination?.id) {
//            R.id.fragment -> {
//                finish()
//            }
//            R.id.addFragment -> {
//                // do nothing\
//                findNavController(R.id.addFragment).navigate()
//
//
//            }
//            R.id.updateFragment -> {
//                // do nothing
//            }
//            R.id.aboutFragment -> {
//                // do nothing
//            }
//            else -> {
//                super.onBackPressed()
//            }
//        }
//
//    }
}
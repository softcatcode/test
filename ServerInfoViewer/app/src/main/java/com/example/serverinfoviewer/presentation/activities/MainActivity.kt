package com.example.serverinfoviewer.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.serverinfoviewer.R
import com.example.serverinfoviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavController()
    }

    private fun setupNavController() {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        setupActionBarWithNavController(
            navController,
            AppBarConfiguration(setOf(R.id.navigation_home, R.id.navigation_dashboard))
        )
        binding.navView.setupWithNavController(navController)
    }
}
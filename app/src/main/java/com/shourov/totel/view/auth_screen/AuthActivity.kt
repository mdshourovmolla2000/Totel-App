package com.shourov.totel.view.auth_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.shourov.totel.R
import com.shourov.totel.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        when(intent.getStringExtra("WHERE_TO_GO").toString()) {
            "CREATE_ACCOUNT" -> navController.navigate(R.id.action_authPlaceholderFragment_to_createAccountFragment)
            "SIGN_IN" -> navController.navigate(R.id.action_authPlaceholderFragment_to_signInFragment)
        }
    }
}
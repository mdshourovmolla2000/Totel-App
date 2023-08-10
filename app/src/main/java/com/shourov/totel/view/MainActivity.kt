package com.shourov.totel.view

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.shourov.totel.R
import com.shourov.totel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var currentFragmentId = R.id.homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        //this will run every time when any fragment changes
        navController.addOnDestinationChangedListener { _, destination, _ ->
            currentFragmentId = destination.id
            when (currentFragmentId) {
                R.id.homeFragment-> {
                    binding.bottomNavigationMenuLayout.visibility = View.VISIBLE
                    bottomMenuSelectedColor(binding.bottomNavigationHomeMenuIcon)
                }
                R.id.bookingsFragment-> {
                    binding.bottomNavigationMenuLayout.visibility = View.VISIBLE
                    bottomMenuSelectedColor(binding.bottomNavigationBookingsMenuIcon)
                }
                R.id.notificationFragment-> {
                    binding.bottomNavigationMenuLayout.visibility = View.VISIBLE
                    bottomMenuSelectedColor(binding.bottomNavigationNotificationMenuIcon)
                }
                R.id.profileFragment-> {
                    binding.bottomNavigationMenuLayout.visibility = View.VISIBLE
                    bottomMenuSelectedColor(binding.bottomNavigationProfileMenuIcon)
                }
                else -> {
                    binding.bottomNavigationMenuLayout.visibility = View.GONE
                }
            }
        }

        binding.bottomNavigationHomeMenu.setOnClickListener {
            if (currentFragmentId != R.id.homeFragment) {
                navController.popBackStack()
            }
        }

        binding.bottomNavigationBookingsMenu.setOnClickListener {
            if (currentFragmentId == R.id.homeFragment) {
                navController.navigate(R.id.action_homeFragment_to_bookingsFragment)
            } else if(currentFragmentId != R.id.bookingsFragment) {
                navController.popBackStack()
                navController.navigate(R.id.action_homeFragment_to_bookingsFragment)
            }
        }

        binding.bottomNavigationNotificationMenu.setOnClickListener {
            if (currentFragmentId == R.id.homeFragment) {
                navController.navigate(R.id.action_homeFragment_to_notificationFragment)
            } else if(currentFragmentId != R.id.notificationFragment) {
                navController.popBackStack()
                navController.navigate(R.id.action_homeFragment_to_notificationFragment)
            }
        }

        binding.bottomNavigationProfileMenu.setOnClickListener {
            if (currentFragmentId == R.id.homeFragment) {
                navController.navigate(R.id.action_homeFragment_to_profileFragment)
            } else if(currentFragmentId != R.id.profileFragment) {
                navController.popBackStack()
                navController.navigate(R.id.action_homeFragment_to_profileFragment)
            }
        }
    }

    private fun bottomMenuSelectedColor(icon: ImageView) {
        binding.bottomNavigationHomeMenuIcon.setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN)
        binding.bottomNavigationBookingsMenuIcon.setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN)
        binding.bottomNavigationNotificationMenuIcon.setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN)
        binding.bottomNavigationProfileMenuIcon.setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN)

        icon.setColorFilter(Color.parseColor("#0057FF"), PorterDuff.Mode.SRC_IN)
    }
}
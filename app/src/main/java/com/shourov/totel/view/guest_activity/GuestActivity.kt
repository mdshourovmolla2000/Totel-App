package com.shourov.totel.view.guest_activity

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.shourov.totel.R
import com.shourov.totel.databinding.ActivityGuestBinding

class GuestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuestBinding
    private lateinit var navController: NavController
    private var currentFragmentId = R.id.guestHomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        //this will run every time when any fragment changes
        navController.addOnDestinationChangedListener { _, destination, _ ->
            currentFragmentId = destination.id
            when (currentFragmentId) {
                R.id.guestHomeFragment-> {
                    binding.bottomNavigationMenuLayout.visibility = View.VISIBLE
                    bottomMenuSelectedColor(binding.bottomNavigationHomeMenuIcon)
                }
                R.id.guestBookingsFragment-> {
                    binding.bottomNavigationMenuLayout.visibility = View.VISIBLE
                    bottomMenuSelectedColor(binding.bottomNavigationBookingsMenuIcon)
                }
                R.id.guestNotificationFragment-> {
                    binding.bottomNavigationMenuLayout.visibility = View.VISIBLE
                    bottomMenuSelectedColor(binding.bottomNavigationNotificationMenuIcon)
                }
                R.id.guestProfileFragment-> {
                    binding.bottomNavigationMenuLayout.visibility = View.VISIBLE
                    bottomMenuSelectedColor(binding.bottomNavigationProfileMenuIcon)
                }
                else -> {
                    binding.bottomNavigationMenuLayout.visibility = View.GONE
                }
            }
        }

        binding.bottomNavigationHomeMenu.setOnClickListener {
            if (currentFragmentId != R.id.guestHomeFragment) {
                navController.popBackStack()
            }
        }

        binding.bottomNavigationBookingsMenu.setOnClickListener {
            if (currentFragmentId == R.id.guestHomeFragment) {
                navController.navigate(R.id.action_guestHomeFragment_to_guestBookingsFragment)
            } else if(currentFragmentId != R.id.guestBookingsFragment) {
                navController.popBackStack()
                navController.navigate(R.id.action_guestHomeFragment_to_guestBookingsFragment)
            }
        }

        binding.bottomNavigationNotificationMenu.setOnClickListener {
            if (currentFragmentId == R.id.guestHomeFragment) {
                navController.navigate(R.id.action_guestHomeFragment_to_guestNotificationFragment)
            } else if(currentFragmentId != R.id.guestNotificationFragment) {
                navController.popBackStack()
                navController.navigate(R.id.action_guestHomeFragment_to_guestNotificationFragment)
            }
        }

        binding.bottomNavigationProfileMenu.setOnClickListener {
            if (currentFragmentId == R.id.guestHomeFragment) {
                navController.navigate(R.id.action_guestHomeFragment_to_guestProfileFragment)
            } else if(currentFragmentId != R.id.guestProfileFragment) {
                navController.popBackStack()
                navController.navigate(R.id.action_guestHomeFragment_to_guestProfileFragment)
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
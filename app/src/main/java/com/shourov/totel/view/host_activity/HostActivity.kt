package com.shourov.totel.view.host_activity

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.shourov.totel.R
import com.shourov.totel.databinding.ActivityHostBinding

class HostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHostBinding
    private lateinit var navController: NavController
    private var currentFragmentId = R.id.hostHomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        //this will run every time when any fragment changes
        navController.addOnDestinationChangedListener { _, destination, _ ->
            currentFragmentId = destination.id
            when (currentFragmentId) {
                R.id.hostHomeFragment-> {
                    binding.bottomNavigationMenuLayout.visibility = View.VISIBLE
                    bottomMenuSelectedColor(binding.bottomNavigationHomeMenuIcon)
                }
                R.id.hostProfileFragment-> {
                    binding.bottomNavigationMenuLayout.visibility = View.VISIBLE
                    bottomMenuSelectedColor(binding.bottomNavigationProfileMenuIcon)
                }
                else -> {
                    binding.bottomNavigationMenuLayout.visibility = View.GONE
                }
            }
        }

        binding.bottomNavigationHomeMenu.setOnClickListener {
            if (currentFragmentId != R.id.hostHomeFragment) {
                navController.popBackStack()
            }
        }

        binding.bottomNavigationSettingsMenu.setOnClickListener {
            if (currentFragmentId == R.id.hostHomeFragment) {
                navController.navigate(R.id.action_hostHomeFragment_to_hostProfileFragment)
            } else if(currentFragmentId != R.id.hostProfileFragment) {
                navController.popBackStack()
                navController.navigate(R.id.action_hostHomeFragment_to_hostProfileFragment)
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
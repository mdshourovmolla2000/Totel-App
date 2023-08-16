package com.shourov.totel.view.welcome_screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentSplashBinding
import com.shourov.totel.utils.SharedPref
import com.shourov.totel.view.auth_screen.AuthActivity
import com.shourov.totel.view.guest_activity.GuestActivity
import com.shourov.totel.view.host_activity.HostActivity

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    private val waitingTime = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        SharedPref.init(requireContext())

        Handler(Looper.getMainLooper()).postDelayed({
            if (SharedPref.read("IS_ON_BOARDING_SCREEN_SHOWED", "") == "yes") {
                if (SharedPref.read("IS_SIGNED_IN", "") == "yes") {
                    if (SharedPref.read("USER_MODE", "") == "host") {
                        val intent = Intent(requireActivity(), HostActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
                    } else {
                        val intent = Intent(requireActivity(), GuestActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
                    }
                } else {
                    val intent = Intent(requireActivity(), AuthActivity::class.java)
                    intent.putExtra("WHERE_TO_GO", "SIGN_IN")
                    startActivity(intent)
                    requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
                }
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
            }
        }, waitingTime * 1000L)

        return binding.root
    }
}
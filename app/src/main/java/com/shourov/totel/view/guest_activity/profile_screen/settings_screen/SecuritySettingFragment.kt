package com.shourov.totel.view.guest_activity.profile_screen.settings_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentSecuritySettingBinding

class SecuritySettingFragment : Fragment() {

    private lateinit var binding: FragmentSecuritySettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecuritySettingBinding.inflate(inflater, container, false)

        binding.backIcon.setOnClickListener { findNavController().popBackStack() }

        binding.changePasswordButton.setOnClickListener { findNavController().navigate(R.id.action_securitySettingFragment_to_changePasswordFragment) }

        return binding.root
    }
}
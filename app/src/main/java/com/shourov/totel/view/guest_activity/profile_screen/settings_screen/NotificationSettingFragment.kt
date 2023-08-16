package com.shourov.totel.view.guest_activity.profile_screen.settings_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shourov.totel.databinding.FragmentNotificationSettingBinding

class NotificationSettingFragment : Fragment() {

    private lateinit var binding: FragmentNotificationSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationSettingBinding.inflate(inflater, container, false)

        binding.backIcon.setOnClickListener { findNavController().popBackStack() }

        return binding.root
    }
}
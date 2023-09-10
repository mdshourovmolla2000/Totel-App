package com.shourov.totel.view.host_activity.home_screen.posting_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentHostPostingStep2Binding

class HostPostingStep2Fragment : Fragment() {

    private lateinit var binding: FragmentHostPostingStep2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostPostingStep2Binding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener { findNavController().popBackStack() }

        binding.continueButton.setOnClickListener { findNavController().navigate(R.id.action_hostPostingStep2Fragment_to_hostPostingAddPriceFragment) }

        return binding.root
    }
}
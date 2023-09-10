package com.shourov.totel.view.host_activity.home_screen.posting_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentHostPostingWhoCanStayBinding

class HostPostingWhoCanStayFragment : Fragment() {

    private lateinit var binding: FragmentHostPostingWhoCanStayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostPostingWhoCanStayBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener { findNavController().popBackStack() }

        binding.continueButton.setOnClickListener { findNavController().navigate(R.id.action_hostPostingWhoCanStayFragment_to_hostPostingStep2Fragment) }

        return binding.root
    }
}
package com.shourov.totel.view.host_activity.home_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentHostHomeBinding

class HostHomeFragment : Fragment() {

    private lateinit var binding: FragmentHostHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostHomeBinding.inflate(inflater, container, false)

        binding.continueButton.setOnClickListener { findNavController().navigate(R.id.action_hostHomeFragment_to_hostPostingPlaceTypeFragment) }

        return binding.root
    }
}
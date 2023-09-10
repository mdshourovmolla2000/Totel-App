package com.shourov.totel.view.host_activity.home_screen.posting_screen

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentHostPostingPlaceTypeBinding

class HostPostingPlaceTypeFragment : Fragment() {

    private lateinit var binding: FragmentHostPostingPlaceTypeBinding

    private var currentlySelected = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostPostingPlaceTypeBinding.inflate(inflater, container, false)

        updateView()

        binding.hotelButton.setOnClickListener {
            if (currentlySelected != "HOTEL") {
                currentlySelected = "HOTEL"
                updateView()
            }
        }

        binding.apartmentButton.setOnClickListener {
            if (currentlySelected != "APARTMENT") {
                currentlySelected = "APARTMENT"
                updateView()
            }
        }

        binding.houseButton.setOnClickListener {
            if (currentlySelected != "HOUSE") {
                currentlySelected = "HOUSE"
                updateView()
            }
        }

        binding.flatButton.setOnClickListener {
            if (currentlySelected != "FLAT") {
                currentlySelected = "FLAT"
                updateView()
            }
        }

        binding.backButton.setOnClickListener { findNavController().popBackStack() }

        binding.continueButton.setOnClickListener { findNavController().navigate(R.id.action_hostPostingPlaceTypeFragment_to_hostPostingRoomTypeFragment) }

        return binding.root
    }

    private fun updateView() {
        binding.hotelButtonBg.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_with_white_bg)
        binding.apartmentButtonBg.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_with_white_bg)
        binding.houseButtonBg.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_with_white_bg)
        binding.flatButtonBg.background = ContextCompat.getDrawable(requireContext(), R.drawable.border_with_white_bg)
        binding.hotelIcon.clearColorFilter()
        binding.apartmentIcon.clearColorFilter()
        binding.houseIcon.clearColorFilter()
        binding.flatIcon.clearColorFilter()
        binding.hotelTextview.setTextColor(Color.parseColor("#272D37"))
        binding.apartmentTextview.setTextColor(Color.parseColor("#272D37"))
        binding.houseTextview.setTextColor(Color.parseColor("#272D37"))
        binding.flatTextview.setTextColor(Color.parseColor("#272D37"))

        when(currentlySelected) {
            "HOTEL" -> {
                binding.hotelButtonBg.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
                binding.hotelIcon.setColorFilter(Color.parseColor("#FFFFFF"))
                binding.hotelTextview.setTextColor(Color.parseColor("#FFFFFF"))
            }
            "APARTMENT" -> {
                binding.apartmentButtonBg.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
                binding.apartmentIcon.setColorFilter(Color.parseColor("#FFFFFF"))
                binding.apartmentTextview.setTextColor(Color.parseColor("#FFFFFF"))
            }
            "HOUSE" -> {
                binding.houseButtonBg.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
                binding.houseIcon.setColorFilter(Color.parseColor("#FFFFFF"))
                binding.houseTextview.setTextColor(Color.parseColor("#FFFFFF"))
            }
            "FLAT" -> {
                binding.flatButtonBg.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.themeColor))
                binding.flatIcon.setColorFilter(Color.parseColor("#FFFFFF"))
                binding.flatTextview.setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
    }
}
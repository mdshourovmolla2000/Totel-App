package com.shourov.totel.view.guest_activity.bookings_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentGuestBookingsBinding

class GuestBookingsFragment : Fragment() {

    private lateinit var binding: FragmentGuestBookingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuestBookingsBinding.inflate(inflater, container, false)

        binding.messagesIcon.setOnClickListener { findNavController().navigate(R.id.action_guestBookingsFragment_to_guestMessagesFragment) }

        return binding.root
    }
}
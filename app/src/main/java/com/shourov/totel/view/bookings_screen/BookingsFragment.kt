package com.shourov.totel.view.bookings_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentBookingsBinding

class BookingsFragment : Fragment() {

    private lateinit var binding: FragmentBookingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookingsBinding.inflate(inflater, container, false)

        binding.messagesIcon.setOnClickListener { findNavController().navigate(R.id.action_bookingsFragment_to_messagesFragment) }

        return binding.root
    }
}
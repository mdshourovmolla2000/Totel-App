package com.shourov.totel.view.auth_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentAuthPlaceholderBinding

class AuthPlaceholderFragment : Fragment() {

    private lateinit var binding: FragmentAuthPlaceholderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAuthPlaceholderBinding.inflate(inflater, container, false)


        return binding.root
    }
}
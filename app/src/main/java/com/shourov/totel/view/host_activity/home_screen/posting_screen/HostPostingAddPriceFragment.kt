package com.shourov.totel.view.host_activity.home_screen.posting_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentHostPostingAddPriceBinding

class HostPostingAddPriceFragment : Fragment() {

    private lateinit var binding: FragmentHostPostingAddPriceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHostPostingAddPriceBinding.inflate(inflater, container, false)


        return binding.root
    }
}
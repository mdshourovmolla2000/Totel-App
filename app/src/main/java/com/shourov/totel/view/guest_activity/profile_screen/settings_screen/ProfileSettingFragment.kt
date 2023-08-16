package com.shourov.totel.view.guest_activity.profile_screen.settings_screen

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.shourov.totel.databinding.FragmentProfileSettingBinding

class ProfileSettingFragment : Fragment() {

    private lateinit var binding: FragmentProfileSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileSettingBinding.inflate(inflater, container, false)

        binding.backIcon.setOnClickListener { findNavController().popBackStack() }

        binding.maleButton.setOnClickListener { selectGender(binding.maleButton) }

        binding.femaleButton.setOnClickListener { selectGender(binding.femaleButton) }

        binding.preferNotToSayButton.setOnClickListener { selectGender(binding.preferNotToSayButton) }

        return binding.root
    }

    private fun selectGender(currentButton: MaterialButton) {
        binding.maleButton.background.setTint(Color.parseColor("#F2F2F7"))
        binding.femaleButton.background.setTint(Color.parseColor("#F2F2F7"))
        binding.preferNotToSayButton.background.setTint(Color.parseColor("#F2F2F7"))

        binding.maleButton.setTextColor(Color.parseColor("#000000"))
        binding.femaleButton.setTextColor(Color.parseColor("#000000"))
        binding.preferNotToSayButton.setTextColor(Color.parseColor("#000000"))

        currentButton.background.setTint(Color.parseColor("#000000"))
        currentButton.setTextColor(Color.parseColor("#FFFFFF"))
    }
}
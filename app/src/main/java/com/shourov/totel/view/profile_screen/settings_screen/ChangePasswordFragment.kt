package com.shourov.totel.view.profile_screen.settings_screen

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentChangePasswordBinding

class ChangePasswordFragment : Fragment() {

    private lateinit var binding: FragmentChangePasswordBinding

    private var isCurrentPasswordVisible = false
    private var isNewPasswordVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChangePasswordBinding.inflate(inflater, container, false)

        binding.backIcon.setOnClickListener { findNavController().popBackStack() }

        binding.currentPasswordToggleIcon.setOnClickListener {
            isCurrentPasswordVisible =!isCurrentPasswordVisible
            binding.currentPasswordEdittext.transformationMethod = if (isCurrentPasswordVisible) null else PasswordTransformationMethod.getInstance()
            binding.currentPasswordToggleIcon.setImageResource(if (isCurrentPasswordVisible) R.drawable.password_show_icon else R.drawable.password_hide_icon)
            binding.currentPasswordEdittext.setSelection(binding.currentPasswordEdittext.text.length)
        }

        binding.newPasswordToggleIcon.setOnClickListener {
            isNewPasswordVisible =!isNewPasswordVisible
            binding.newPasswordEdittext.transformationMethod = if (isNewPasswordVisible) null else PasswordTransformationMethod.getInstance()
            binding.newPasswordToggleIcon.setImageResource(if (isNewPasswordVisible) R.drawable.password_show_icon else R.drawable.password_hide_icon)
            binding.newPasswordEdittext.setSelection(binding.newPasswordEdittext.text.length)
        }

        return binding.root
    }
}
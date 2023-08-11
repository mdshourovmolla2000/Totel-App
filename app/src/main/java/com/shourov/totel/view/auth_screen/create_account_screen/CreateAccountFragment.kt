package com.shourov.totel.view.auth_screen.create_account_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentCreateAccountBinding
import com.shourov.totel.utils.KeyboardManager

class CreateAccountFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateAccountBinding.inflate(inflater, container, false)

        binding.backIcon.setOnClickListener { requireActivity().onBackPressed() }

        binding.signInButton.setOnClickListener { findNavController().navigate(R.id.action_createAccountFragment_to_signInFragment) }

        binding.countryCodePicker.registerCarrierNumberEditText(binding.mobileNumberEdittext)

        binding.continueButton.setOnClickListener {
            if (binding.mobileNumberEdittext.text.toString().trim().isEmpty()) {
                binding.mobileNumberEdittext.error = "Enter mobile number"
                binding.mobileNumberEdittext.requestFocus()
                return@setOnClickListener
            }
            KeyboardManager.hideKeyBoard(requireContext(), it)

            val bundle = bundleOf(
                "MOBILE_NUMBER" to "+"+binding.countryCodePicker.fullNumber
            )
            findNavController().navigate(R.id.action_createAccountFragment_to_createAccountOtpVerificationFragment, bundle)
        }

        return binding.root
    }
}
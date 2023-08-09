package com.shourov.totel.view.auth_screen.sign_in_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentSignInBinding
import com.shourov.totel.utils.KeyboardManager

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater, container, false)

        binding.backIcon.setOnClickListener { requireActivity().finish() }

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
            findNavController().navigate(R.id.action_signInFragment_to_signInOtpVerificationFragment, bundle)
        }

        return binding.root
    }
}
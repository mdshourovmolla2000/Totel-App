package com.shourov.totel.view.auth_screen.create_account_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentCreateAccountNameBinding
import com.shourov.totel.utils.KeyboardManager

class CreateAccountNameFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateAccountNameBinding.inflate(inflater, container, false)

        binding.continueButton.setOnClickListener {
            if (binding.firstNameEdittext.text.toString().trim().isEmpty()) {
                binding.firstNameEdittext.error = "Enter name"
                binding.firstNameEdittext.requestFocus()
                return@setOnClickListener
            }

            KeyboardManager.hideKeyBoard(requireContext(), it)

            findNavController().navigate(R.id.action_createAccountNameFragment_to_createAccountDateOfBirthFragment)
        }

        return binding.root
    }
}
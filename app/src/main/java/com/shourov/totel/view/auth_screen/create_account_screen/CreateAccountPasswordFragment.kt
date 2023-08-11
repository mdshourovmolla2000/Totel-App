package com.shourov.totel.view.auth_screen.create_account_screen

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentCreateAccountPasswordBinding
import com.shourov.totel.utils.KeyboardManager

class CreateAccountPasswordFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountPasswordBinding

    private var isPasswordVisible = false
    private var isConfirmPasswordVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateAccountPasswordBinding.inflate(inflater, container, false)

        binding.passwordToggleIcon.setOnClickListener {
            isPasswordVisible =!isPasswordVisible
            binding.passwordEdittext.transformationMethod = if (isPasswordVisible) null else PasswordTransformationMethod.getInstance()
            binding.passwordToggleIcon.setImageResource(if (isPasswordVisible) R.drawable.password_show_icon else R.drawable.password_hide_icon)
            binding.passwordEdittext.setSelection(binding.passwordEdittext.text.length)
        }

        binding.confirmPasswordToggleIcon.setOnClickListener {
            isConfirmPasswordVisible =!isConfirmPasswordVisible
            binding.confirmPasswordEdittext.transformationMethod = if (isConfirmPasswordVisible) null else PasswordTransformationMethod.getInstance()
            binding.confirmPasswordToggleIcon.setImageResource(if (isConfirmPasswordVisible) R.drawable.password_show_icon else R.drawable.password_hide_icon)
            binding.confirmPasswordEdittext.setSelection(binding.confirmPasswordEdittext.text.length)
        }

        binding.continueButton.setOnClickListener {
            if (binding.passwordEdittext.text.toString().length < 8) {
                binding.passwordEdittext.error = "Must be 8 digit"
                binding.passwordEdittext.requestFocus()
                return@setOnClickListener
            }
            if (binding.confirmPasswordEdittext.text.toString().length < 8) {
                binding.confirmPasswordEdittext.error = "Must be 8 digit"
                binding.confirmPasswordEdittext.requestFocus()
                return@setOnClickListener
            }

            if (binding.passwordEdittext.text.toString() != binding.confirmPasswordEdittext.text.toString()) {
                binding.confirmPasswordEdittext.error = "Password not matched"
                binding.confirmPasswordEdittext.requestFocus()
                return@setOnClickListener
            }

            KeyboardManager.hideKeyBoard(requireContext(), it)

            findNavController().navigate(R.id.action_createAccountPasswordFragment_to_createAccountNameFragment)
        }

        return binding.root
    }
}
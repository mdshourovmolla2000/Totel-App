package com.shourov.totel.view.auth_screen.sign_in_screen

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentSignInPasswordBinding
import com.shourov.totel.utils.KeyboardManager
import com.shourov.totel.view.MainActivity

class SignInPasswordFragment : Fragment() {

    private lateinit var binding: FragmentSignInPasswordBinding

    private var isPasswordVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInPasswordBinding.inflate(inflater, container, false)

        binding.passwordToggleIcon.setOnClickListener {
            isPasswordVisible =!isPasswordVisible
            binding.passwordEdittext.transformationMethod = if (isPasswordVisible) null else PasswordTransformationMethod.getInstance()
            binding.passwordToggleIcon.setImageResource(if (isPasswordVisible) R.drawable.password_show_icon else R.drawable.password_hide_icon)
            binding.passwordEdittext.setSelection(binding.passwordEdittext.text.length)
        }

        binding.signInButton.setOnClickListener {
            if (binding.passwordEdittext.text.toString().length < 8) {
                binding.passwordEdittext.error = "Must be 8 digit"
                binding.passwordEdittext.requestFocus()
                return@setOnClickListener
            }

            KeyboardManager.hideKeyBoard(requireContext(), it)

            val intent = Intent(requireActivity(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
        }

        return binding.root
    }
}
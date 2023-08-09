package com.shourov.totel.view.auth_screen.sign_in_screen

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentSignInOtpVerificationBinding
import com.shourov.totel.utils.KeyboardManager

class SignInOtpVerificationFragment : Fragment() {

    private lateinit var binding: FragmentSignInOtpVerificationBinding

    private lateinit var mobileNumber: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInOtpVerificationBinding.inflate(inflater, container, false)

        mobileNumber = arguments?.getString("MOBILE_NUMBER").toString()

        resendOtpTimer()

        binding.mobileNumberTextview.text = mobileNumber

        binding.pinView.doOnTextChanged { text, start, before, count ->
            if (text.toString().length == 6) {
                binding.confirmButton.isEnabled = true
                binding.confirmButton.background.setTint(ContextCompat.getColor(requireContext(), R.color.themeColor))
                binding.confirmButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            } else {
                binding.confirmButton.isEnabled = false
                binding.confirmButton.background.setTint(Color.parseColor("#F2F2F7"))
                binding.confirmButton.setTextColor(Color.parseColor("#993C3C43"))
            }
        }

        binding.resendOtpButton.setOnClickListener { resendOtpTimer() }

        binding.confirmButton.setOnClickListener {
            KeyboardManager.hideKeyBoard(requireContext(), it)
            findNavController().navigate(R.id.action_signInOtpVerificationFragment_to_signInPasswordFragment)
        }

        return binding.root
    }

    private fun resendOtpTimer() {
        binding.resendOtpButton.isEnabled = false
        binding.resendOtpButton.background.setTint(Color.parseColor("#99EBEBF5"))
        binding.resendOtpButton.setTextColor(Color.parseColor("#993C3C43"))
        val countdownTime = 60 //in second
        object : CountDownTimer(countdownTime * 1000L, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = (millisUntilFinished / 1000) % 60
                val minutesRemaining = (millisUntilFinished / 1000) / 60
                binding.resendOtpButton.text = "I haven’t received a code ($minutesRemaining:$secondsRemaining)"
            }

            override fun onFinish() {
                binding.resendOtpButton.background.setTint(Color.parseColor("#99EBEBF5"))
                binding.resendOtpButton.setTextColor(Color.parseColor("#000000"))
                binding.resendOtpButton.text = "I haven’t received a code"
                binding.resendOtpButton.isEnabled = true
            }
        }.start()
    }
}
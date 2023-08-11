package com.shourov.totel.view.auth_screen.create_account_screen

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.shourov.totel.R
import com.shourov.totel.databinding.FragmentCreateAccountDateOfBirthBinding
import com.shourov.totel.utils.KeyboardManager
import com.shourov.totel.utils.showErrorToast
import com.shourov.totel.utils.showWarningToast

class CreateAccountDateOfBirthFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountDateOfBirthBinding

    private var selectedGender = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateAccountDateOfBirthBinding.inflate(inflater, container, false)

        when(selectedGender){
            "male" -> selectGender("male", binding.maleButton)
            "female" -> selectGender("female", binding.femaleButton)
            "prefer_not_to_say" -> selectGender("prefer_not_to_say", binding.preferNotToSayButton)
        }

        binding.maleButton.setOnClickListener { selectGender("male", binding.maleButton) }

        binding.femaleButton.setOnClickListener { selectGender("female", binding.femaleButton) }

        binding.preferNotToSayButton.setOnClickListener { selectGender("prefer_not_to_say", binding.preferNotToSayButton) }

        binding.continueButton.setOnClickListener {
            if (selectedGender.isEmpty()) {
                requireContext().showWarningToast("Select Gender")
                return@setOnClickListener
            }

            KeyboardManager.hideKeyBoard(requireContext(), it)

            findNavController().navigate(R.id.action_createAccountDateOfBirthFragment_to_createAccountProfilePictureFragment)
        }

        return binding.root
    }

    private fun selectGender(gender: String, currentButton: MaterialButton) {
        selectedGender = gender

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
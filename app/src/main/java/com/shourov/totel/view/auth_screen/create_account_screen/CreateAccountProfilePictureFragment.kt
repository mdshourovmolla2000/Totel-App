package com.shourov.totel.view.auth_screen.create_account_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shourov.totel.R
import com.shourov.totel.databinding.BottomSheetChangeProfilePicBinding
import com.shourov.totel.databinding.FragmentCreateAccountProfilePictureBinding

class CreateAccountProfilePictureFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountProfilePictureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateAccountProfilePictureBinding.inflate(inflater, container, false)

        binding.chooseAPhotoButton.setOnClickListener { chooseAPhoto() }

        binding.skipButton.setOnClickListener { findNavController().navigate(R.id.action_createAccountProfilePictureFragment_to_createAccountHobbiesFragment) }

        return binding.root
    }

    private fun chooseAPhoto() {
        val bottomSheet = BottomSheetDialog(requireContext())
        val bottomSheetBinding = BottomSheetChangeProfilePicBinding.bind(LayoutInflater.from(requireContext()).inflate(R.layout.bottom_sheet_change_profile_pic, null))

        bottomSheet.setContentView(bottomSheetBinding.root)

        bottomSheetBinding.takePhotoButton.setOnClickListener { bottomSheet.dismiss() }

        bottomSheetBinding.addFromGalleryButton.setOnClickListener { bottomSheet.dismiss() }

        bottomSheet.show()
    }
}
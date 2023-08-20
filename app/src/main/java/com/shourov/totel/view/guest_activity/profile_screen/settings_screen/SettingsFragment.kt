package com.shourov.totel.view.guest_activity.profile_screen.settings_screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shourov.totel.R
import com.shourov.totel.databinding.BottomSheetSignOutBinding
import com.shourov.totel.databinding.BottomSheetUpdateAppBinding
import com.shourov.totel.databinding.FragmentSettingsBinding
import com.shourov.totel.utils.SharedPref
import com.shourov.totel.utils.showSuccessToast
import com.shourov.totel.view.welcome_screen.WelcomeActivity

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        SharedPref.init(requireContext())

        binding.backIcon.setOnClickListener { findNavController().popBackStack() }

        binding.switchButton.setOnClickListener {
            SharedPref.write("USER_MODE", "host")
            val intent = Intent(requireActivity(), WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
        }

        binding.profileButton.setOnClickListener { findNavController().navigate(R.id.action_settingsFragment_to_profileSettingFragment) }

        binding.notificationButton.setOnClickListener { findNavController().navigate(R.id.action_settingsFragment_to_notificationSettingFragment) }

        binding.securityButton.setOnClickListener { findNavController().navigate(R.id.action_settingsFragment_to_securitySettingFragment) }

        binding.versionButton.setOnClickListener { updateDialog() }

        binding.tosButton.setOnClickListener { findNavController().navigate(R.id.action_settingsFragment_to_termOfServiceFragment) }

        binding.privacyPolicyButton.setOnClickListener { findNavController().navigate(R.id.action_settingsFragment_to_privacyPolicyFragment) }

        binding.signOutButton.setOnClickListener { signOutDialog() }

        return binding.root
    }

    private fun updateDialog() {
        val bottomSheet = BottomSheetDialog(requireContext())
        val bottomSheetBinding = BottomSheetUpdateAppBinding.bind(LayoutInflater.from(requireContext()).inflate(
            R.layout.bottom_sheet_update_app, null))

        bottomSheet.setContentView(bottomSheetBinding.root)

        bottomSheetBinding.closeButton.setOnClickListener { bottomSheet.dismiss() }

        bottomSheetBinding.updateNowButton.setOnClickListener { bottomSheet.dismiss() }

        bottomSheetBinding.noButton.setOnClickListener { bottomSheet.dismiss() }

        bottomSheet.show()
    }

    private fun signOutDialog() {
        val bottomSheet = BottomSheetDialog(requireContext())
        val bottomSheetBinding = BottomSheetSignOutBinding.bind(LayoutInflater.from(requireContext()).inflate(
            R.layout.bottom_sheet_sign_out, null))

        bottomSheet.setContentView(bottomSheetBinding.root)

        bottomSheetBinding.closeButton.setOnClickListener { bottomSheet.dismiss() }

        bottomSheetBinding.yesButton.setOnClickListener {
            bottomSheet.dismiss()
            requireContext().showSuccessToast("Signed Out")
            SharedPref.write("IS_SIGNED_IN", "no")
            SharedPref.write("USER_MODE", "guest")
            val intent = Intent(requireActivity(), WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            requireActivity().overridePendingTransition(R.anim.enter, R.anim.exit)
        }

        bottomSheetBinding.cancelButton.setOnClickListener { bottomSheet.dismiss() }

        bottomSheet.show()
    }
}
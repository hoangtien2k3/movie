package com.dcht.themoviedb.ui.profile.policy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dcht.themoviedb.BuildConfig
import com.dcht.themoviedb.R
import com.dcht.themoviedb.common.viewBinding
import com.dcht.themoviedb.databinding.FragmentPolicyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PolicyFragment : Fragment(R.layout.fragment_policy){
    private val binding by viewBinding(FragmentPolicyBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            // versionName
            "version: ${BuildConfig.VERSION_NAME}".also { versionName.text = it }
        }
    }
}
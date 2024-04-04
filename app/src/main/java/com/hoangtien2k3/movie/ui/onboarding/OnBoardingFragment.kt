package com.hoangtien2k3.movie.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hoangtien2k3.movie.R
import com.hoangtien2k3.movie.common.viewBinding
import com.hoangtien2k3.movie.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {
    private val binding by viewBinding(FragmentOnBoardingBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding)
        {
            getStarted.setOnClickListener {
                val action =
                    OnBoardingFragmentDirections.actionOnBoardingFragmentToSignInWithSocialFragment()
                findNavController().navigate(action)
            }
        }
    }
}
package com.dcht.themoviedb.ui.profile

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dcht.themoviedb.R
import com.dcht.themoviedb.common.Resource
import com.dcht.themoviedb.common.enums.ImageTypeEnum
import com.dcht.themoviedb.common.loadImage
import com.dcht.themoviedb.common.showToast
import com.dcht.themoviedb.common.viewBinding
import com.dcht.themoviedb.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import www.sanju.motiontoast.MotionToastStyle

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel: ProfileViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collectData()
        initUI()
    }

    private fun initUI() {
        with(binding) {
            with(viewModel) {
                getCurrentLanguage()
                getDarkMode()

                signOut.setOnClickListener {
                    val action =
                        ProfileFragmentDirections.actionProfileFragmentToLogoutDialogFragment()
                    findNavController().navigate(action)
                }

                darkModeToggle.setOnClickListener {
                    if (darkModeToggle.isChecked) {
                        setDarkMode(true)
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                    } else {
                        setDarkMode(false)
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                    }
                }

                languageLayout.setOnClickListener {
                    val action =
                        ProfileFragmentDirections.actionProfileFragmentToLanguageFragment()
                    findNavController().navigate(action)
                }

                helpCenterLayout.setOnClickListener {
                    val action =
                        ProfileFragmentDirections.actionProfileFragmentToHelpCenterContactFragment()
                    findNavController().navigate(action)
                }

                privacyPolicyLayout.setOnClickListener {
                    val action =
                        ProfileFragmentDirections.actionProfileFragmentToPolicyFragment()
                    findNavController().navigate(action)
                }

                downloadLayout.setOnClickListener {
                    val action =
                        ProfileFragmentDirections.actionProfileFragmentToDownloadFragment()
                    findNavController().navigate(action)
                }

            }
        }
    }

    private fun collectData() {
        with(binding) {
            with(viewModel) {
                viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                    userInfo.collectLatest { response ->
                        when (response) {
                            is Resource.Loading -> {

                            }

                            is Resource.Error -> {
                                requireActivity().showToast(
                                    getString(R.string.error),
                                    response.throwable.localizedMessage ?: "Error",
                                    MotionToastStyle.ERROR
                                )

                            }

                            is Resource.Success -> {
                                emailTv.text = response.data.email
                                displayNameTv.text = response.data.displayName ?: getString(R.string.account_name)
                                userIv.loadImage(
                                    response.data.photoUrl.toString(),
                                    imageTypeEnum = ImageTypeEnum.CREDIT
                                )
                            }
                        }
                    }

                }

                viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                    darkMode.collectLatest { response ->
                        when (response) {
                            is Resource.Loading -> {
                            }

                            is Resource.Error -> {
                                requireActivity().showToast(
                                    getString(R.string.error),
                                    response.throwable.localizedMessage ?: "Error",
                                    MotionToastStyle.ERROR
                                )

                            }

                            is Resource.Success -> {
                                darkModeToggle.isChecked = response.data
                                if (response.data) {
                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                                } else {
                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                                }
                            }
                        }
                    }

                }

                lifecycleScope.launchWhenCreated {
                    currentLanguage.collectLatest { response ->

                        when (response) {
                            is Resource.Loading -> {
                            }

                            is Resource.Error -> {
                                requireActivity().showToast(
                                    getString(R.string.error),
                                    response.throwable.localizedMessage ?: "Error",
                                    MotionToastStyle.ERROR
                                )

                            }

                            is Resource.Success -> {
                                currentLanguageTv.text = response.data
                            }
                        }
                    }
                }
            }
        }
    }
}
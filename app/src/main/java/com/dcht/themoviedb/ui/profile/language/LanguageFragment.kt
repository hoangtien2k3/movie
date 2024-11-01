package com.dcht.themoviedb.ui.profile.language

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dcht.themoviedb.R
import com.dcht.themoviedb.common.*
import com.dcht.themoviedb.databinding.FragmentLanguageBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import www.sanju.motiontoast.MotionToastStyle
import java.util.*

@AndroidEntryPoint
class LanguageFragment : Fragment(R.layout.fragment_language) {
    private val binding by viewBinding(FragmentLanguageBinding::bind)
    private val viewModel: LanguageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        collectData()
    }

    fun initUI() {
        with(binding) {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            with(viewModel) {

            }
        }
    }

    fun onClick(language: String, code: String) {
        viewModel.setLanguage(language)
        viewModel.setLanguageCode(code)

        val locale = Locale(code)
        val config = Configuration()
        config.setLocale(locale)
        val resources = context?.resources
        resources?.updateConfiguration(config, resources.displayMetrics)
        requireActivity().recreate()

        findNavController().popBackStack()
    }

    fun collectData() {
        with(viewModel) {
            with(binding) {

                lifecycleScope.launchWhenCreated {
                    currentLanguageCode.collectLatest { response ->

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
                                languagesRecycler.visible()

                                collectLanguages(response.data)

                            }
                        }
                    }
                }


            }
        }
    }

    private fun collectLanguages(currentLanguageCode: String) {
        with(viewModel) {
            with(binding) {

                lifecycleScope.launchWhenCreated {
                    languages.collectLatest { response ->

                        when (response) {
                            is Resource.Loading -> {
                                languagesRecycler.gone()
                            }
                            is Resource.Error -> {
                                languagesRecycler.gone()

                                requireActivity().showToast(
                                    getString(R.string.error),
                                    response.throwable.localizedMessage ?: "Error",
                                    MotionToastStyle.ERROR
                                )

                            }
                            is Resource.Success -> {
                                languagesRecycler.visible()

                                val adapter =
                                    LanguagesAdapter(response.data, currentLanguageCode)
                                languagesRecycler.adapter = adapter
                                adapter.onClick = ::onClick

                            }
                        }
                    }
                }


            }
        }
    }

}
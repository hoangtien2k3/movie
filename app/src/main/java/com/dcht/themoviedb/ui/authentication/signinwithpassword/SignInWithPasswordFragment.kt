package com.dcht.themoviedb.ui.authentication.signinwithpassword

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dcht.themoviedb.R
import com.dcht.themoviedb.common.*
import com.dcht.themoviedb.data.model.DialogArguments
import com.dcht.themoviedb.databinding.FragmentSignInWithPasswordBinding
import com.dcht.themoviedb.ui.dialog.DialogFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import www.sanju.motiontoast.MotionToastStyle

@AndroidEntryPoint
class SignInWithPasswordFragment : Fragment(R.layout.fragment_sign_in_with_password) {
    private val binding by viewBinding(FragmentSignInWithPasswordBinding::bind)
    private val viewModel: SignInWithPasswordViewModel by viewModels()
    private var isPasswordShowing: Boolean = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        collectData()
    }

    private fun initUI() {
        with(binding) {
            with(viewModel) {
                backButton.setOnClickListener {
                    findNavController().popBackStack()
                }
                signUp.setOnClickListener {
                    val action =
                        com.dcht.themoviedb.ui.authentication.signinwithpassword.SignInWithPasswordFragmentDirections.actionSignInWithPasswordFragmentToSignUpFragment()
                    findNavController().navigate(action)
                }
                showHidePassword.setOnClickListener {
                    if (isPasswordShowing) {
                        showHidePassword.setImageResource(R.drawable.dark_theme)
                        passwordEditText.transformationMethod = PasswordTransformationMethod()
                        isPasswordShowing = false
                    } else {
                        showHidePassword.setImageResource(R.drawable.hide)
                        passwordEditText.transformationMethod = null
                        isPasswordShowing = true
                    }
                }
                passwordEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
                    passwordEditText.changeFocusedInputTint(hasFocus)
                    if (hasFocus) {
                        showHidePassword.setColorFilter(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.text_color
                            )
                        )
                    } else {
                        if (passwordEditText.text.toString().isEmpty()) {
                            showHidePassword.setColorFilter(
                                ContextCompat.getColor(
                                    requireContext(),
                                    R.color.inactive_input
                                )
                            )
                        }
                    }
                }
                emailEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
                    emailEditText.changeFocusedInputTint(hasFocus)
                }
                signIn.setOnClickListener {
                    signIn(emailEditText.text.toString(), passwordEditText.text.toString())
                }
            }
        }
    }

    private fun collectData() {
        with(viewModel) {
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                user.collectLatest { response ->
                    when (response) {
                        is Resource.Loading -> {
                            LoadingScreen.displayLoading(requireContext(), false)
                        }
                        is Resource.Error -> {
                            LoadingScreen.hideLoading()
                            requireActivity().showToast(
                                getString(R.string.error),
                                response.throwable.localizedMessage ?: "Error",
                                MotionToastStyle.ERROR
                            )

                        }
                        is Resource.Success -> {
                            LoadingScreen.hideLoading()
                            val action =
                                com.dcht.themoviedb.ui.authentication.signinwithpassword.SignInWithPasswordFragmentDirections.actionSignInWithPasswordFragmentToDialogFragment(
                                    DialogArguments(
                                        getString(R.string.congratulations),
                                        getString(R.string.successful_sign_in),
                                        R.drawable.dialog_profile,
                                        DialogFragmentDirections.actionDialogFragmentToHomeFragment()
                                    )
                                )
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }
}
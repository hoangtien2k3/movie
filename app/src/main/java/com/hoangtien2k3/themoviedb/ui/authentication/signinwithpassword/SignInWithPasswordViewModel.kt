package com.hoangtien2k3.themoviedb.ui.authentication.signinwithpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import com.hoangtien2k3.themoviedb.common.Resource
import com.hoangtien2k3.themoviedb.domain.use_case.authentication.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInWithPasswordViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _user = MutableSharedFlow<Resource<AuthResult>>()
    val user
        get() = _user.asSharedFlow()

    fun signIn(email: String, password: String) = viewModelScope.launch {
        signInUseCase(email, password).collectLatest {
            _user.emit(it)
        }
    }
}
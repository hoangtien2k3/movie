package com.dcht.themoviedb.ui.authentication.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import com.dcht.themoviedb.common.Resource
import com.dcht.themoviedb.domain.use_case.authentication.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    private val _user = MutableSharedFlow<Resource<AuthResult>>()
    val user
        get() = _user.asSharedFlow()

    fun signUp(email: String, password: String) = viewModelScope.launch {
        signUpUseCase(email, password).collectLatest {
            _user.emit(it)
        }
    }
}
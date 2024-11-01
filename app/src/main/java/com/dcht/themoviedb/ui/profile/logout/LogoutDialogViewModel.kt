package com.dcht.themoviedb.ui.profile.logout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dcht.themoviedb.common.Resource
import com.dcht.themoviedb.domain.use_case.profile.SignOut
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogoutDialogViewModel @Inject constructor(private val signOutUseCase: SignOut) : ViewModel() {


    private val _authResult = MutableSharedFlow<Resource<Boolean>>()
    val authResult
        get() = _authResult.asSharedFlow()

    fun signOut() = viewModelScope.launch {
        signOutUseCase().collectLatest {
            _authResult.emit(it)
        }
    }

}
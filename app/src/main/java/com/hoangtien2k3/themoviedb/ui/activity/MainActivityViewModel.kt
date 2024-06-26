package com.hoangtien2k3.themoviedb.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hoangtien2k3.themoviedb.common.Resource
import com.hoangtien2k3.themoviedb.domain.use_case.profile.GetDarkModeUseCase
import com.hoangtien2k3.themoviedb.domain.use_case.profile.language.GetCurrentLanguageCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getDarkModeUseCase: GetDarkModeUseCase,
    private val getCurrentLanguageCodeUseCase: GetCurrentLanguageCodeUseCase
) : ViewModel() {


    private val _darkMode = MutableStateFlow<Resource<Boolean>>(Resource.Loading)
    val darkMode
        get() = _darkMode.asStateFlow()

    private val _currentLanguageCode = MutableStateFlow<Resource<String>>(Resource.Loading)
    val currentLanguageCode get() = _currentLanguageCode.asStateFlow()


    fun getDarkMode() = viewModelScope.launch {
        getDarkModeUseCase().collectLatest {
            _darkMode.emit(it)
        }
    }

    fun getCurrentLanguageCode() = viewModelScope.launch {
        getCurrentLanguageCodeUseCase().collectLatest {
            _currentLanguageCode.emit(it)
        }
    }

}
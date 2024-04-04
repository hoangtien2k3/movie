package com.hoangtien2k3.movie.ui.download

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hoangtien2k3.movie.common.Resource
import com.hoangtien2k3.movie.data.model.local.Download
import com.hoangtien2k3.movie.domain.use_case.download.GetDownloadsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DownloadViewModel @Inject constructor(
    private val getDownloadsUseCase: GetDownloadsUseCase
) : ViewModel() {

    private val _downloads = MutableStateFlow<Resource<List<Download>>>(Resource.Loading)
    val downloads
        get() = _downloads.asStateFlow()


    fun getDownloads() = viewModelScope.launch {
        getDownloadsUseCase().collectLatest {
            _downloads.emit(it)
        }
    }
}
package com.hoangtien2k3.movie.ui.dialog.download

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hoangtien2k3.movie.data.model.local.Download
import com.hoangtien2k3.movie.domain.use_case.download.AddDownloadUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DownloadDialogViewModel @Inject constructor(private val addDownloadUseCase: AddDownloadUseCase) :
    ViewModel() {

    fun addDownload(download: Download) = viewModelScope.launch { addDownloadUseCase(download) }
}
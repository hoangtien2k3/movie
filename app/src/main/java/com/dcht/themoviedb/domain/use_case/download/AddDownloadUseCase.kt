package com.dcht.themoviedb.domain.use_case.download

import com.dcht.themoviedb.data.model.local.Download
import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class AddDownloadUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    suspend operator fun invoke(download: Download) = movaRepository.addDownload(download)
}
package com.hoangtien2k3.themoviedb.domain.use_case.download

import com.hoangtien2k3.themoviedb.data.model.local.Download
import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class AddDownloadUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    suspend operator fun invoke(download: Download) = movaRepository.addDownload(download)
}
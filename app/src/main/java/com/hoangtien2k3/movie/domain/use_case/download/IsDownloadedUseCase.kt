package com.hoangtien2k3.movie.domain.use_case.download

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class IsDownloadedUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(id: Int) = movaRepository.isDownloaded(id)
}
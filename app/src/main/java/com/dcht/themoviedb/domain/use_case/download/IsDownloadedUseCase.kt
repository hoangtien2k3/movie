package com.dcht.themoviedb.domain.use_case.download

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class IsDownloadedUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(id: Int) = movaRepository.isDownloaded(id)
}
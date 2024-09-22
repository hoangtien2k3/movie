package com.dcht.themoviedb.domain.use_case.download

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class RemoveDownloadedUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    suspend operator fun invoke(id: Int) = movaRepository.removeDownloaded(id)
}
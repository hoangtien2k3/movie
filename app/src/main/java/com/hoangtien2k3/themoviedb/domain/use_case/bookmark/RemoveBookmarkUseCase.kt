package com.hoangtien2k3.themoviedb.domain.use_case.bookmark

import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class RemoveBookmarkUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    suspend operator fun invoke(id: Int) {
        movaRepository.removeBookmark(id)
    }
}
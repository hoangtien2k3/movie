package com.hoangtien2k3.movie.domain.use_case.bookmark

import com.hoangtien2k3.movie.data.model.local.Bookmark
import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class AddBookmarkUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    suspend operator fun invoke(bookmark: Bookmark) {
        movaRepository.addBookmark(bookmark)
    }
}
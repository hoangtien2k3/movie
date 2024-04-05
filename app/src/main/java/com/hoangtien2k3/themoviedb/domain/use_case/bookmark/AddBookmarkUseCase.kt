package com.hoangtien2k3.themoviedb.domain.use_case.bookmark

import com.hoangtien2k3.themoviedb.data.model.local.Bookmark
import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class AddBookmarkUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    suspend operator fun invoke(bookmark: Bookmark) {
        movaRepository.addBookmark(bookmark)
    }
}
package com.dcht.themoviedb.domain.use_case.bookmark

import com.dcht.themoviedb.data.model.local.Bookmark
import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class AddBookmarkUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    suspend operator fun invoke(bookmark: Bookmark) {
        movaRepository.addBookmark(bookmark)
    }
}
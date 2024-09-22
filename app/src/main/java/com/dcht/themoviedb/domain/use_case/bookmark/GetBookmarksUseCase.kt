package com.dcht.themoviedb.domain.use_case.bookmark

import com.dcht.themoviedb.common.Resource
import com.dcht.themoviedb.data.model.local.Bookmark
import com.dcht.themoviedb.domain.repository.MovaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarksUseCase @Inject constructor(
    private val movaRepository: MovaRepository
) {
    operator fun invoke(): Flow<Resource<List<Bookmark>>> = movaRepository.getBookmarks()
}
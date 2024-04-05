package com.hoangtien2k3.themoviedb.domain.use_case.bookmark

import com.hoangtien2k3.themoviedb.common.Resource
import com.hoangtien2k3.themoviedb.data.model.local.Bookmark
import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarksUseCase @Inject constructor(
    private val movaRepository: MovaRepository
) {
    operator fun invoke(): Flow<Resource<List<Bookmark>>> = movaRepository.getBookmarks()
}
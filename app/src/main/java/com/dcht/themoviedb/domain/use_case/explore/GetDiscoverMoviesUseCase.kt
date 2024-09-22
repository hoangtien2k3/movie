package com.dcht.themoviedb.domain.use_case.explore

import com.dcht.themoviedb.data.model.FilterResult
import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetDiscoverMoviesUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(filterResult: FilterResult?) =
        movaRepository.getDiscoverMovies(filterResult)
}
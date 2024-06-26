package com.hoangtien2k3.themoviedb.domain.use_case.explore

import com.hoangtien2k3.themoviedb.data.model.FilterResult
import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetDiscoverMoviesUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(filterResult: FilterResult?) =
        movaRepository.getDiscoverMovies(filterResult)
}
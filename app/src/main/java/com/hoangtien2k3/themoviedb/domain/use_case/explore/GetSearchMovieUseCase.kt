package com.hoangtien2k3.themoviedb.domain.use_case.explore

import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetSearchMovieUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(query: String, includeAdult: Boolean) =
        movaRepository.getSearchMovie(query, includeAdult)
}
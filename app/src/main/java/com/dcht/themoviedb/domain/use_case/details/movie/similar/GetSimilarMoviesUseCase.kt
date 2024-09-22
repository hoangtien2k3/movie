package com.dcht.themoviedb.domain.use_case.details.movie.similar

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetSimilarMoviesUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(movieId: Int) = movaRepository.getSimilarMovies(movieId)
}
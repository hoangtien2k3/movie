package com.dcht.themoviedb.domain.use_case.home

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val movieRepository: MovaRepository) {
    operator fun invoke() = movieRepository.getPopularMovies()
}

package com.hoangtien2k3.movie.domain.use_case.home

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val movieRepository: MovaRepository) {
    operator fun invoke() = movieRepository.getPopularMovies()
}

package com.hoangtien2k3.themoviedb.domain.use_case.home

import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(private val movieRepository: MovaRepository) {
    operator fun invoke() = movieRepository.getNowPlayingMovies()
}
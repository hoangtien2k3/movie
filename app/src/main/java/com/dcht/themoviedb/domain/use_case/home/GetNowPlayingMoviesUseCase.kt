package com.dcht.themoviedb.domain.use_case.home

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(private val movieRepository: MovaRepository) {
    operator fun invoke() = movieRepository.getNowPlayingMovies()
}

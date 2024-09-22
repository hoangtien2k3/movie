package com.dcht.themoviedb.domain.use_case.details.movie

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieCreditsUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(movieId: Int) = movaRepository.getMovieCredits(movieId)
}
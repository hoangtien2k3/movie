package com.hoangtien2k3.movie.domain.use_case.details.movie

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieCreditsUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(movieId: Int) = movaRepository.getMovieCredits(movieId)
}
package com.hoangtien2k3.movie.domain.use_case.details.movie

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovaRepository
) {
    operator fun invoke(movieId: Int) = repository.getMovieDetails(movieId)
}
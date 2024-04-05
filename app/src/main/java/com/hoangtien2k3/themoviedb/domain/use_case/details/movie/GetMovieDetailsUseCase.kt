package com.hoangtien2k3.themoviedb.domain.use_case.details.movie

import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovaRepository
) {
    operator fun invoke(movieId: Int) = repository.getMovieDetails(movieId)
}
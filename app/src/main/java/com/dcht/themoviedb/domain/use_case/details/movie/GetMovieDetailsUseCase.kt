package com.dcht.themoviedb.domain.use_case.details.movie

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovaRepository
) {
    operator fun invoke(movieId: Int) = repository.getMovieDetails(movieId)
}
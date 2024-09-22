package com.dcht.themoviedb.domain.use_case.details.movie.trailers

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieTrailersUseCase @Inject constructor(val repository: MovaRepository) {
    operator fun invoke(movieId: Int) = repository.getMovieTrailers(movieId)
}
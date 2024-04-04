package com.hoangtien2k3.movie.domain.use_case.details.movie.trailers

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieTrailersUseCase @Inject constructor(val repository: MovaRepository) {
    operator fun invoke(movieId: Int) = repository.getMovieTrailers(movieId)
}
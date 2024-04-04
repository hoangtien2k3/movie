package com.hoangtien2k3.movie.domain.use_case.details.movie.images

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieImagesUseCase @Inject constructor(private val repository: MovaRepository) {
    operator fun invoke(movieId: Int) = repository.getMovieImages(movieId)
}
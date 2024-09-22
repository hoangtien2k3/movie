package com.dcht.themoviedb.domain.use_case.details.movie.images

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieImagesUseCase @Inject constructor(private val repository: MovaRepository) {
    operator fun invoke(movieId: Int) = repository.getMovieImages(movieId)
}
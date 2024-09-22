package com.dcht.themoviedb.domain.use_case.filter

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieGenresUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke() = movaRepository.getMovieGenres()
}
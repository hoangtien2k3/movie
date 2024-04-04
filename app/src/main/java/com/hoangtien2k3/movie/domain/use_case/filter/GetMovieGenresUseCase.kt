package com.hoangtien2k3.movie.domain.use_case.filter

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetMovieGenresUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke() = movaRepository.getMovieGenres()
}
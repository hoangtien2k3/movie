package com.hoangtien2k3.themoviedb.domain.use_case.filter

import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetSerieGenresUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke() = movaRepository.getSerieGenres()
}
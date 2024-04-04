package com.hoangtien2k3.movie.domain.use_case.person

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetPersonDetailsUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(id: Int) = movaRepository.getPersonDetails(id)
}
package com.dcht.themoviedb.domain.use_case.person

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetPersonDetailsUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(id: Int) = movaRepository.getPersonDetails(id)
}
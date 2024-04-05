package com.hoangtien2k3.themoviedb.domain.use_case.person.series

import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetPersonSerieCreditsUseCase @Inject constructor(private val repository: MovaRepository) {
    operator fun invoke(personId: Int) = repository.getPersonSerieCredits(personId)
}
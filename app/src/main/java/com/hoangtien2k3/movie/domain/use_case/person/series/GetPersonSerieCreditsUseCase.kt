package com.hoangtien2k3.movie.domain.use_case.person.series

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetPersonSerieCreditsUseCase @Inject constructor(private val repository: MovaRepository) {
    operator fun invoke(personId: Int) = repository.getPersonSerieCredits(personId)
}
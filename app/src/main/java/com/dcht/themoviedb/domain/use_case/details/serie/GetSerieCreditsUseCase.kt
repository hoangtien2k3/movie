package com.dcht.themoviedb.domain.use_case.details.serie

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetSerieCreditsUseCase @Inject constructor(val repository: MovaRepository) {
    operator fun invoke(id: Int) = repository.getSerieCredits(id)
}
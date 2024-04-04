package com.hoangtien2k3.movie.domain.use_case.details.serie

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetSerieDetailsUseCase @Inject constructor(val repository: MovaRepository) {
    operator fun invoke(id: Int) = repository.getSerieDetails(id)
}
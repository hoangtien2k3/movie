package com.hoangtien2k3.movie.domain.use_case.details.serie.trailers

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetSerieTrailersUseCase @Inject constructor(val repository: MovaRepository) {
    operator fun invoke(serieId: Int) = repository.getSerieTrailers(serieId)
}
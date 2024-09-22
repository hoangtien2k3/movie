package com.dcht.themoviedb.domain.use_case.details.serie.trailers

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetSerieTrailersUseCase @Inject constructor(val repository: MovaRepository) {
    operator fun invoke(serieId: Int) = repository.getSerieTrailers(serieId)
}
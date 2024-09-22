package com.dcht.themoviedb.domain.use_case.details.serie.similar

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetSimilarSeriesUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(serieId: Int) = movaRepository.getSimilarSeries(serieId)
}
package com.hoangtien2k3.movie.domain.use_case.details.serie.similar

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetSimilarSeriesUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(serieId: Int) = movaRepository.getSimilarSeries(serieId)
}
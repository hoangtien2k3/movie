package com.hoangtien2k3.movie.domain.use_case.explore

import com.hoangtien2k3.movie.data.model.FilterResult
import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetDiscoverSeriesUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(filterResult: FilterResult?) =
        movaRepository.getDiscoverSeries(filterResult)
}
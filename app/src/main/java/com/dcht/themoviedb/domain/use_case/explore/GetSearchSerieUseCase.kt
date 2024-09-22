package com.dcht.themoviedb.domain.use_case.explore

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetSearchSerieUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(query: String, includeAdult: Boolean) =
        movaRepository.getSearchSerie(query, includeAdult)
}
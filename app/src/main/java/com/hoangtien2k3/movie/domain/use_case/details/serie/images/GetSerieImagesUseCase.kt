package com.hoangtien2k3.movie.domain.use_case.details.serie.images

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetSerieImagesUseCase @Inject constructor(private val repository: MovaRepository) {
    operator fun invoke(serieId: Int) = repository.getSerieImages(serieId)
}
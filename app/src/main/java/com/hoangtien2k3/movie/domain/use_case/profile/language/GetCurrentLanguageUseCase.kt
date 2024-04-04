package com.hoangtien2k3.movie.domain.use_case.profile.language

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetCurrentLanguageUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke() = movaRepository.getCurrentLanguage()
}
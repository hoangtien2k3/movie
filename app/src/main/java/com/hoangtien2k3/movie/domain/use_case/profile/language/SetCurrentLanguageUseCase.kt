package com.hoangtien2k3.movie.domain.use_case.profile.language

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class SetCurrentLanguageUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(language: String) = movaRepository.setCurrentLanguage(language)
}
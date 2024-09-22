package com.dcht.themoviedb.domain.use_case.profile.language

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetCurrentLanguageUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke() = movaRepository.getCurrentLanguage()
}
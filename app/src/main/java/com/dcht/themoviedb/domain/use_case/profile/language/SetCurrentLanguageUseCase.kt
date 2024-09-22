package com.dcht.themoviedb.domain.use_case.profile.language

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class SetCurrentLanguageUseCase @Inject constructor(private val movaRepository: MovaRepository) {
    operator fun invoke(language: String) = movaRepository.setCurrentLanguage(language)
}
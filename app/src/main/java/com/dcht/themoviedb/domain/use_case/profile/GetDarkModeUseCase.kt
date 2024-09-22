package com.dcht.themoviedb.domain.use_case.profile

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetDarkModeUseCase @Inject constructor(
    private val movaRepository: MovaRepository
) {
    operator fun invoke() = movaRepository.getDarkMode()
}
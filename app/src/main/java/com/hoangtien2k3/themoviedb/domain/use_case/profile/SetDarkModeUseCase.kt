package com.hoangtien2k3.themoviedb.domain.use_case.profile

import com.hoangtien2k3.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class SetDarkModeUseCase @Inject constructor(
    private val movaRepository: MovaRepository
) {
    operator fun invoke(isDarkMode: Boolean) = movaRepository.setDarkMode(isDarkMode)
}

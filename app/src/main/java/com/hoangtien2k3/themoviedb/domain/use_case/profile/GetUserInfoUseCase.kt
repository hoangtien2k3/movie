package com.hoangtien2k3.themoviedb.domain.use_case.profile

import com.hoangtien2k3.themoviedb.domain.repository.AuthRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getUserInfo()
}

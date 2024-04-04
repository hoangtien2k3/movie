package com.hoangtien2k3.movie.domain.use_case.profile

import com.hoangtien2k3.movie.domain.repository.AuthRepository
import javax.inject.Inject

class SignOut @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.signOut()
}
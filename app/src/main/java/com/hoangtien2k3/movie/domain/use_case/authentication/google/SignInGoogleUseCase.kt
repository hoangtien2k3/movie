package com.hoangtien2k3.movie.domain.use_case.authentication.google

import com.hoangtien2k3.movie.domain.repository.AuthRepository
import javax.inject.Inject

class SignInGoogleUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.signInWithGoogle()
}
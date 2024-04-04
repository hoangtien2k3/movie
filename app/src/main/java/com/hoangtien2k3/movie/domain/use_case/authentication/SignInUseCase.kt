package com.hoangtien2k3.movie.domain.use_case.authentication

import com.hoangtien2k3.movie.domain.repository.AuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(email: String, password: String) = repository.signIn(email, password)
}
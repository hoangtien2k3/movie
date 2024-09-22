package com.dcht.themoviedb.domain.use_case.authentication.google

import com.dcht.themoviedb.domain.repository.AuthRepository
import javax.inject.Inject

class SignInGoogleUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.signInWithGoogle()
}
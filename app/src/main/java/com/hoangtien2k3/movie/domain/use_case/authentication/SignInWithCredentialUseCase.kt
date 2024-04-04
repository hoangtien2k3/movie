package com.hoangtien2k3.movie.domain.use_case.authentication

import com.google.firebase.auth.AuthCredential
import com.hoangtien2k3.movie.domain.repository.AuthRepository
import javax.inject.Inject

class SignInWithCredentialUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(credential: AuthCredential) = repository.signInWithCredential(credential)
}
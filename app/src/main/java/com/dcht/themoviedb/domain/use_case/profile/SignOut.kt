package com.dcht.themoviedb.domain.use_case.profile

import com.dcht.themoviedb.domain.repository.AuthRepository
import javax.inject.Inject

class SignOut @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.signOut()
}
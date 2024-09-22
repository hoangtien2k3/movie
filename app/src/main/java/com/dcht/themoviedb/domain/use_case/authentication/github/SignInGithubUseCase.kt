package com.dcht.themoviedb.domain.use_case.authentication.github

import android.app.Activity
import com.dcht.themoviedb.domain.repository.AuthRepository
import javax.inject.Inject

class SignInGithubUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(activity: Activity) = repository.signInWithGithub(activity)
}
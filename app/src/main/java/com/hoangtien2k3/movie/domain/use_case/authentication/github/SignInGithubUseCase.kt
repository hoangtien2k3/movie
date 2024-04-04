package com.hoangtien2k3.movie.domain.use_case.authentication.github

import android.app.Activity
import com.hoangtien2k3.movie.domain.repository.AuthRepository
import javax.inject.Inject

class SignInGithubUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke(activity: Activity) = repository.signInWithGithub(activity)
}
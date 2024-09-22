package com.dcht.themoviedb.domain.use_case.person.movies

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetPersonMovieCreditsUseCase @Inject constructor(private val repository: MovaRepository) {
    suspend operator fun invoke(personId: Int) = repository.getPersonMovieCredits(personId)
}

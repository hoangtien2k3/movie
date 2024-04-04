package com.hoangtien2k3.movie.domain.use_case.person.movies

import com.hoangtien2k3.movie.domain.repository.MovaRepository
import javax.inject.Inject

class GetPersonMovieCreditsUseCase @Inject constructor(private val repository: MovaRepository) {
    suspend operator fun invoke(personId: Int) = repository.getPersonMovieCredits(personId)
}

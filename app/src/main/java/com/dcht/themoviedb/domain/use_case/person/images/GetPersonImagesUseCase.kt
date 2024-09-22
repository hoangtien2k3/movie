package com.dcht.themoviedb.domain.use_case.person.images

import com.dcht.themoviedb.domain.repository.MovaRepository
import javax.inject.Inject

class GetPersonImagesUseCase @Inject constructor(private val repository: MovaRepository) {
    operator fun invoke(personId: Int) = repository.getPersonImages(personId)
}
package com.hoangtien2k3.themoviedb.ui.person.movies

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hoangtien2k3.themoviedb.common.Constants
import com.hoangtien2k3.themoviedb.common.Resource
import com.hoangtien2k3.themoviedb.domain.model.MovieUI
import com.hoangtien2k3.themoviedb.domain.use_case.person.movies.GetPersonMovieCreditsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonMoviesViewModel @Inject constructor(
    private val getPersonMovieCreditsUseCase: GetPersonMovieCreditsUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _movies = MutableStateFlow<Resource<List<MovieUI>>>(Resource.Loading)
    val movies
        get() = _movies.asStateFlow()

    init {
        savedStateHandle.get<Int>(Constants.Arguments.ID)?.let { id ->
            getPersonMovieCredits(id)
        }
    }

    private fun getPersonMovieCredits(id: Int) = viewModelScope.launch {
        getPersonMovieCreditsUseCase(id).collectLatest {
            _movies.emit(it)
        }
    }
}
package com.dcht.themoviedb.ui.player

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dcht.themoviedb.common.Constants
import com.dcht.themoviedb.common.Resource
import com.dcht.themoviedb.common.enums.MediaTypeEnum
import com.dcht.themoviedb.domain.model.VideoUI
import com.dcht.themoviedb.domain.use_case.details.movie.trailers.GetMovieTrailersUseCase
import com.dcht.themoviedb.domain.use_case.details.serie.trailers.GetSerieTrailersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoPlayerViewModel @Inject constructor(
    private val getMovieTrailersUseCase: GetMovieTrailersUseCase,
    private val getSerieTrailersUseCase: GetSerieTrailersUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _trailers = MutableStateFlow<Resource<List<VideoUI>>>(Resource.Loading)
    val trailers
        get() = _trailers.asStateFlow()

    init {
        savedStateHandle.get<Int>(Constants.Arguments.ID)?.let { id ->
            savedStateHandle.get<MediaTypeEnum>(Constants.Arguments.MEDIA_TYPE)?.let { mediaType ->
                if (id != 0) {
                    when (mediaType) {
                        MediaTypeEnum.MOVIE -> {
                            getMovieTrailers(id)
                        }
                        MediaTypeEnum.SERIE -> {
                            getSerieTrailers(id)
                        }
                    }
                }
            }
        }
    }

    private fun getMovieTrailers(movieId: Int) = viewModelScope.launch {
        getMovieTrailersUseCase(movieId).collectLatest {
            _trailers.emit(it)
        }
    }

    private fun getSerieTrailers(serieId: Int) = viewModelScope.launch {
        getSerieTrailersUseCase(serieId).collectLatest {
            _trailers.emit(it)
        }
    }
}
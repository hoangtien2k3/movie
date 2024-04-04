package com.hoangtien2k3.movie.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hoangtien2k3.movie.common.Resource
import com.hoangtien2k3.movie.data.model.local.Bookmark
import com.hoangtien2k3.movie.domain.model.MovieUI
import com.hoangtien2k3.movie.domain.model.SerieUI
import com.hoangtien2k3.movie.domain.use_case.bookmark.AddBookmarkUseCase
import com.hoangtien2k3.movie.domain.use_case.bookmark.RemoveBookmarkUseCase
import com.hoangtien2k3.movie.domain.use_case.home.GetNowPlayingMoviesUseCase
import com.hoangtien2k3.movie.domain.use_case.home.GetNowPlayingSeriesUseCase
import com.hoangtien2k3.movie.domain.use_case.home.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getNowPlayingSeriesUseCase: GetNowPlayingSeriesUseCase,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val removeBookmarkUseCase: RemoveBookmarkUseCase
) : ViewModel() {

    private val _popularMovies = MutableStateFlow<Resource<List<MovieUI>>>(Resource.Loading)
    val popularMovies
        get() = _popularMovies.asStateFlow()

    private val _nowPlayingMovies =
        MutableStateFlow<PagingData<MovieUI>>(PagingData.empty())
    val nowPlayingMovies
        get() = _nowPlayingMovies.asStateFlow()

    private val _nowPlayingSeries = MutableStateFlow<PagingData<SerieUI>>(PagingData.empty())
    val nowPlayingSeries
        get() = _nowPlayingSeries.asStateFlow()


    init {
        getPopularMovies()
        getNowPlayingMovies()
        getNowPlayingSeries()
    }

    private fun getPopularMovies() = viewModelScope.launch {
        getPopularMoviesUseCase().collectLatest {
            _popularMovies.emit(it)
        }
    }

    private fun getNowPlayingMovies() = viewModelScope.launch {
        getNowPlayingMoviesUseCase().cachedIn(viewModelScope).collectLatest {
            _nowPlayingMovies.emit(it)

        }
    }

    private fun getNowPlayingSeries() = viewModelScope.launch {
        getNowPlayingSeriesUseCase().cachedIn(viewModelScope).collectLatest {
            _nowPlayingSeries.emit(it)
        }
    }

    fun addBookmark(bookmark: Bookmark) = viewModelScope.launch {
        addBookmarkUseCase(bookmark)
    }

    fun removeBookmark(id: Int) = viewModelScope.launch {
        removeBookmarkUseCase(id)
    }
}
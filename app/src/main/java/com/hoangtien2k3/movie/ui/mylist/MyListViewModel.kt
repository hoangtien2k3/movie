package com.hoangtien2k3.movie.ui.mylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hoangtien2k3.movie.common.Resource
import com.hoangtien2k3.movie.data.model.local.Bookmark
import com.hoangtien2k3.movie.domain.use_case.bookmark.GetBookmarksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyListViewModel @Inject constructor(private val getBookmarksUseCase: GetBookmarksUseCase) :
    ViewModel() {

    private val _bookmarks = MutableStateFlow<Resource<List<Bookmark>>>(Resource.Loading)
    val bookmarks
        get() = _bookmarks.asStateFlow()

    fun getBookmarks() = viewModelScope.launch {
        getBookmarksUseCase().collectLatest {
            _bookmarks.emit(it)
        }
    }
}
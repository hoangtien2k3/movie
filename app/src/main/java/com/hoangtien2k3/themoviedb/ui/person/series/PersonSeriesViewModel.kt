package com.hoangtien2k3.themoviedb.ui.person.series

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hoangtien2k3.themoviedb.common.Constants
import com.hoangtien2k3.themoviedb.common.Resource
import com.hoangtien2k3.themoviedb.domain.model.SerieUI
import com.hoangtien2k3.themoviedb.domain.use_case.person.series.GetPersonSerieCreditsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonSeriesViewModel @Inject constructor(
    private val getPersonSerieCreditsUseCase: GetPersonSerieCreditsUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _series = MutableStateFlow<Resource<List<SerieUI>>>(Resource.Loading)
    val series
        get() = _series.asStateFlow()

    init {
        savedStateHandle.get<Int>(Constants.Arguments.ID)?.let { id ->
            getPersonSerieCredits(id)
        }
    }

    private fun getPersonSerieCredits(id: Int) = viewModelScope.launch {
        getPersonSerieCreditsUseCase(id).collectLatest {
            _series.emit(it)
        }
    }
}
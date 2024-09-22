package com.dcht.themoviedb.data.model

import android.os.Parcelable
import com.dcht.themoviedb.common.Constants
import com.dcht.themoviedb.common.enums.MediaTypeEnum
import com.dcht.themoviedb.data.model.remote.genres.Genre
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilterResult(
    var type: MediaTypeEnum = MediaTypeEnum.MOVIE,
    var selectedGenreList: MutableList<Genre> = mutableListOf(),
    var sortBy: String = Constants.SortBy.POPULARITY,
    var includeAdult: Boolean = false,
    var genreList: List<Genre> = emptyList()
) : Parcelable

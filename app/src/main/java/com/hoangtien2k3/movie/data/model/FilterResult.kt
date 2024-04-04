package com.hoangtien2k3.movie.data.model

import android.os.Parcelable
import com.hoangtien2k3.movie.common.Constants
import com.hoangtien2k3.movie.common.enums.MediaTypeEnum
import com.hoangtien2k3.movie.data.model.remote.genres.Genre
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilterResult(
    var type: MediaTypeEnum = MediaTypeEnum.MOVIE,
    var selectedGenreList: MutableList<Genre> = mutableListOf(),
    var sortBy: String = Constants.SortBy.POPULARITY,
    var includeAdult: Boolean = false,
    var genreList: List<Genre> = emptyList()
) : Parcelable

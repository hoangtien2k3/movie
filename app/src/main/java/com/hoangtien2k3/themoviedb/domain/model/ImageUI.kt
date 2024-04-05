package com.hoangtien2k3.themoviedb.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageUI(
    val filePath: String,
    val voteCount: Int,
) : Parcelable

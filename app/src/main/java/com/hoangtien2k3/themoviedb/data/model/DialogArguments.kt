package com.hoangtien2k3.themoviedb.data.model

import androidx.navigation.NavDirections
import java.io.Serializable

data class DialogArguments(
    val title: String,
    val message: String,
    val imageResource: Int,
    val navigationDestination: NavDirections
) : Serializable

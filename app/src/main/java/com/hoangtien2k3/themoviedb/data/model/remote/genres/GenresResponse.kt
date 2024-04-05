package com.hoangtien2k3.themoviedb.data.model.remote.genres


import com.google.gson.annotations.SerializedName

data class GenresResponse(
    @SerializedName("genres")
    val genres: List<Genre>
)
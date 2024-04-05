package com.hoangtien2k3.themoviedb.data.model.remote.person.series


import com.google.gson.annotations.SerializedName

data class PersonSerieCreditsResponse(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("id")
    val id: Int
)
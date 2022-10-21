package com.twaun95.data.model.boxoffice

import com.google.gson.annotations.SerializedName

data class BoxOfficeResponse(
    @SerializedName("boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult
)

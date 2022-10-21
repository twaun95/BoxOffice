package com.twaun95.data.model.info

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Actor(
    val cast: String,
    val castEn: String,
    val peopleNm: String,
    val peopleNmEn: String
)
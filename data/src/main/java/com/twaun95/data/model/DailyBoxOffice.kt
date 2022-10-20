package com.twaun95.data.model

import com.google.gson.annotations.SerializedName
import com.twaun95.domain.model.MovieEntity

data class DailyBoxOffice(
    @SerializedName("audiAcc")
    val audiAcc: String,
    @SerializedName("audiChange")
    val audiChange: String,
    @SerializedName("audiCnt")
    val audiCnt: String,
    @SerializedName("audiInten")
    val audiInten: String,
    @SerializedName("movieCd")
    val movieCd: String,
    @SerializedName("movieNm")
    val movieNm: String,
    @SerializedName("openDt")
    val openDt: String,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("rankInten")
    val rankInten: String,
    @SerializedName("rankOldAndNew")
    val rankOldAndNew: String,
    @SerializedName("rnum")
    val rnum: String,
    @SerializedName("salesAcc")
    val salesAcc: String,
    @SerializedName("salesAmt")
    val salesAmt: String,
    @SerializedName("salesChange")
    val salesChange: String,
    @SerializedName("salesInten")
    val salesInten: String,
    @SerializedName("salesShare")
    val salesShare: String,
    @SerializedName("scrnCnt")
    val scrnCnt: String,
    @SerializedName("showCnt")
    val showCnt: String
) {
    companion object {
        fun toMovieEntity(boxOffice: DailyBoxOffice) : MovieEntity{
            return MovieEntity(
                code = boxOffice.movieCd,
                name = boxOffice.movieNm,
                rank = boxOffice.rank,
                openDate = boxOffice.openDt
            )
        }
    }
}
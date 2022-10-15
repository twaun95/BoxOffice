package com.twaun95.data.service

import com.twaun95.data.model.BoxOfficeResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    //TODO 쿼리, 패뜨 인지 판단
    @GET("/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getBoxOffice(
        @Query("key") key : String,
        @Query("targetDt") date : String,
    ) : Response<BoxOfficeResult>
}
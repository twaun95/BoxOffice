package com.twaun95.data.service

import com.twaun95.data.model.BoxOfficeResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getBoxOffice(
        @Query("key") key : String,
        @Query("targetDt") date : String,
    ) : Response<BoxOfficeResult>
}
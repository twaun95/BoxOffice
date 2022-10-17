package com.twaun95.data.service

import com.twaun95.data.model.BoxOfficeResponse
import com.twaun95.data.model.BoxOfficeResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getBoxOffice(
        @Query("key") key : String,
        @Query("targetDt") date : String,
        @Query("itemPerPage") page : String? = null,
        @Query("multiMovieYn") a : String? = null,
        @Query("repNationCd") b : String? = null,
        @Query("wideAreaCd") c : String? = null
    ) : Response<BoxOfficeResponse>
}
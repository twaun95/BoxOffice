package com.twaun95.data.service

import com.twaun95.data.model.boxoffice.BoxOfficeResponse
import com.twaun95.data.model.info.MovieInfoResult
import com.twaun95.data.model.search.SearchMovieListResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getBoxOffice(
        @Query("key") key: String,
        @Query("targetDt") date: String,
        @Query("itemPerPage") page: String? = null,
        @Query("multiMovieYn") a: String? = null,
        @Query("repNationCd") b: String? = null,
        @Query("wideAreaCd") c: String? = null
    ): Response<BoxOfficeResponse>

    @GET("kobisopenapi/webservice/rest/movie/searchMovieInfo.json")
    suspend fun getMovieInfo(
        @Query("key") key: String,
        @Query("movieCd") code: String
    ): Response<MovieInfoResult>

    @GET("kobisopenapi/webservice/rest/movie/searchMovieList.json")
    suspend fun getMovies(
        @Query("key") key: String,
        @Query("movieNm") name: String
    ): Response<SearchMovieListResult>
}
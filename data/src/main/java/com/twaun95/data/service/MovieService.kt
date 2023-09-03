package com.twaun95.data.service

import com.twaun95.data.model.boxoffice.BoxOfficeResponse
import com.twaun95.data.model.info.MovieInfoResult
import com.twaun95.data.model.search.movie.SearchMovieListResult
import com.twaun95.data.model.search.people.SearchPeopleResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("boxoffice/searchDailyBoxOfficeList.json")
    suspend fun getSearchDailyBoxOfficeList(
        @Query("key") key: String,
        @Query("targetDt") date: String,
        @Query("itemPerPage") page: String? = null,
        @Query("multiMovieYn") a: String? = null,
        @Query("repNationCd") b: String? = null,
        @Query("wideAreaCd") c: String? = null
    ): Response<BoxOfficeResponse>

    @GET("movie/searchMovieInfo.json")
    suspend fun getSearchMovieInfo(
        @Query("key") key: String,
        @Query("movieCd") code: String
    ): Response<MovieInfoResult>

    @GET("movie/searchMovieList.json")
    suspend fun getSearchMovieList(
        @Query("key") key: String,
        @Query("movieNm") movieName: String,
        @Query("curPage") currentPage: String,
        @Query("itemPerPage") itemSizePerPage: String
    ): Response<SearchMovieListResult>

    @GET("people/searchPeopleList.json")
    suspend fun getSearchPeopleList(
        @Query("key") key: String,
        @Query("peopleNm") name: String
    ): Response<SearchPeopleResult>
}
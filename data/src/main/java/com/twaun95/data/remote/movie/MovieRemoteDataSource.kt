package com.twaun95.data.remote.movie

import com.twaun95.data.model.boxoffice.BoxOfficeResponse
import com.twaun95.data.model.info.MovieInfoResult
import com.twaun95.data.remote.RemoteDataSource
import retrofit2.Response

interface MovieRemoteDataSource : RemoteDataSource {
    suspend fun getBoxOffice(date: String) : Response<BoxOfficeResponse>
    suspend fun getMovieInfo(code: String): Response<MovieInfoResult>
}
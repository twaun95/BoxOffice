package com.twaun95.data.remote.movie

import com.twaun95.data.model.APIKey
import com.twaun95.data.model.boxoffice.BoxOfficeResponse
import com.twaun95.data.model.info.MovieInfoResult
import com.twaun95.data.service.MovieService
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieService: MovieService,
    private val apiKey: APIKey
) : MovieRemoteDataSource {
    override suspend fun getBoxOffice(date: String): Response<BoxOfficeResponse> {
        return movieService.getBoxOffice(
            key = apiKey.key,
            date = date
        )
    }

    override suspend fun getMovieInfo(code: String): Response<MovieInfoResult> {
        return movieService.getMovieInfo(
            key = apiKey.key,
            code = code
        )
    }
}
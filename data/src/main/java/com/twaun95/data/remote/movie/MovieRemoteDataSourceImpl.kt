package com.twaun95.data.remote.movie

import com.twaun95.data.model.APIKey
import com.twaun95.data.model.boxoffice.BoxOfficeResponse
import com.twaun95.data.model.info.MovieInfoResult
import com.twaun95.data.model.search.movie.SearchMovieListResult
import com.twaun95.data.model.search.people.SearchPeopleResult
import com.twaun95.data.service.MovieService
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieService: MovieService,
    private val apiKey: APIKey
) : MovieRemoteDataSource {
    override suspend fun getBoxOffice(date: String): Response<BoxOfficeResponse> {
        return movieService.getSearchDailyBoxOfficeList(
            key = apiKey.key,
            date = date
        )
    }

    override suspend fun getMovieInfo(code: String): Response<MovieInfoResult> {
        return movieService.getSearchMovieInfo(
            key = apiKey.key,
            code = code
        )
    }

    override suspend fun searchMovieList(
        movieName: String,
        page: Int,
        pageSize: Int
    ): Response<SearchMovieListResult> {
        return movieService.getSearchMovieList(
            key = apiKey.key,
            movieName = movieName,
            currentPage = page.toString(),
            itemSizePerPage = pageSize.toString()
        )
    }

    override suspend fun getSearchPeople(peopleName: String): Response<SearchPeopleResult> {
        return movieService.getSearchPeopleList(
            key = apiKey.key,
            name = peopleName
        )
    }
}
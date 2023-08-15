package com.twaun95.data.remote.movie

import com.twaun95.data.model.boxoffice.BoxOfficeResponse
import com.twaun95.data.model.info.MovieInfoResult
import com.twaun95.data.model.search.movie.SearchMovieListResult
import com.twaun95.data.model.search.people.SearchPeopleResult
import com.twaun95.data.remote.RemoteDataSource
import retrofit2.Response

interface MovieRemoteDataSource : RemoteDataSource {
    suspend fun getBoxOffice(date: String) : Response<BoxOfficeResponse>
    suspend fun getMovieInfo(code: String): Response<MovieInfoResult>
    suspend fun getSearchMovies(movieName: String): Response<SearchMovieListResult>
    suspend fun getSearchPeople(peopleName: String): Response<SearchPeopleResult>
}
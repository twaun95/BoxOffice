package com.twaun95.data.repository

import com.twaun95.data.model.boxoffice.DailyBoxOffice
import com.twaun95.data.model.info.MovieInfo
import com.twaun95.data.model.search.Movie
import com.twaun95.data.remote.movie.MovieRemoteDataSource
import com.twaun95.domain.model.entity.movie.BoxOfficeEntity
import com.twaun95.domain.model.entity.movie.MovieEntity
import com.twaun95.domain.model.Result
import com.twaun95.domain.repository.movie.MovieRepository
import javax.inject.Inject
import kotlin.Exception

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {
    override suspend fun getBoxOffice(date: String) : Result<List<BoxOfficeEntity>> {
        val response = movieRemoteDataSource.getBoxOffice(date)

        return try {
            if (response.isSuccessful) {
                return Result.Success(response.body()!!.boxOfficeResult.dailyBoxOfficeList!!.map {
                    DailyBoxOffice.toBoxOfficeEntity(it)
                })
            } else {
                Result.Fail(IllegalArgumentException("일일 박스 오피스 불러오기 실패."))
            }
        } catch (e: Exception) {
            Result.Fail(e)
        }
    }

    override suspend fun getMovieInfo(code: String): Result<MovieEntity> {
        val response = movieRemoteDataSource.getMovieInfo(code)

        return try {
            if (response.isSuccessful) {
                return Result.Success(response.body()!!.movieInfoResult.movieInfo.run {
                    MovieInfo.toMovieEntity(this)
                })
            } else {
                Result.Fail(IllegalArgumentException("영화 정보 불러오기 실패."))
            }
        } catch (e: Exception) {
            Result.Fail(e)
        }
    }

    override suspend fun getMovies(movieName: String): Result<List<MovieEntity>> {
        if (movieName.isEmpty()) return Result.Success(emptyList())

        val response = movieRemoteDataSource.getSearchMovieList(movieName = movieName)
        return try {
            if (response.isSuccessful) {
                return Result.Success(response.body()!!.movieListResult.movieList.map {
                    Movie.toMovieEntity(it)
                })
            } else {
                Result.Fail(IllegalArgumentException("영화 정보 불러오기 실패."))
            }
        } catch (e: Exception) {
            Result.Fail(e)
        }
    }
}
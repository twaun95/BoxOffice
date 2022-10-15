package com.twaun95.data.repository

import com.twaun95.data.model.DailyBoxOffice
import com.twaun95.data.service.MovieService
import com.twaun95.domain.model.MovieEntity
import com.twaun95.domain.model.Result
import com.twaun95.domain.repository.MovieRepository
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService
) : MovieRepository {
    override suspend fun getBoxOffice(key: String, date: String) : Result<List<MovieEntity>> {
        val response = movieService.getBoxOffice(key, date)

        return try {
            if (response.isSuccessful) {
                return Result.Success(response.body()!!.dailyBoxOfficeList.map {
                    DailyBoxOffice.toMovieEntity(it)
                })
            } else {
                Result.Fail(IllegalArgumentException("영화 불러오기 실패."))
            }
        } catch (e: Exception) {
            Result.Fail(e)
        }
    }

    override suspend fun getMovieDetail() {
        TODO("Not yet implemented")
    }
}
package com.twaun95.data.repository

import com.twaun95.data.model.APIKey
import com.twaun95.data.model.DailyBoxOffice
import com.twaun95.data.service.MovieService
import com.twaun95.domain.model.MovieEntity
import com.twaun95.domain.model.Result
import com.twaun95.domain.repository.MovieRepository
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val apiKey: APIKey
) : MovieRepository {
    override suspend fun getBoxOffice(date: String) : Result<List<MovieEntity>> {
        Timber.d("Taewaun ${apiKey.key}")
        Timber.d("Taewaun $date")

        val response = movieService.getBoxOffice(apiKey.key, date)

        return try {
            if (response.isSuccessful) {
                Timber.d("Taewaun success${response.code()}")
                Timber.d("Taewaun success${response.body()!!}")

                return Result.Success(response.body()!!.dailyBoxOfficeList!!.map {
                    DailyBoxOffice.toMovieEntity(it)
                })
            } else {
                Timber.d("Taewaun fail")

                Result.Fail(IllegalArgumentException("영화 불러오기 실패."))
            }
        } catch (e: Exception) {
            Timber.d("Taewaun e ${e.message}")

            Result.Fail(e)
        }
    }
}
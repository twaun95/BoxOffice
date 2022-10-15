package com.twaun95.domain.repository

import com.twaun95.domain.model.MovieEntity
import com.twaun95.domain.model.Result

interface MovieRepository {
    suspend fun getBoxOffice(key: String, date: String) : Result<List<MovieEntity>>
    suspend fun getMovieDetail()
}
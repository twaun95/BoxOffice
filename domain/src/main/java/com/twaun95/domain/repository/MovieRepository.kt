package com.twaun95.domain.repository

import com.twaun95.domain.model.MovieEntity
import com.twaun95.domain.model.Result

interface MovieRepository {
    suspend fun getBoxOffice(date: String) : Result<List<MovieEntity>>
}
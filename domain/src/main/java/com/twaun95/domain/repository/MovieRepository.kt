package com.twaun95.domain.repository

import com.twaun95.domain.model.entity.BoxOfficeEntity
import com.twaun95.domain.model.entity.MovieEntity
import com.twaun95.domain.model.Result

interface MovieRepository {
    suspend fun getBoxOffice(date: String) : Result<List<BoxOfficeEntity>>
    suspend fun getMovieInfo(code: String) : Result<MovieEntity>
}
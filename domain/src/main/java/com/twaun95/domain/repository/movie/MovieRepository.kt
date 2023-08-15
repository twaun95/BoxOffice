package com.twaun95.domain.repository.movie

import com.twaun95.domain.model.entity.movie.BoxOfficeEntity
import com.twaun95.domain.model.entity.movie.MovieEntity
import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.movie.PeopleEntity
import com.twaun95.domain.repository.Repository

interface MovieRepository : Repository {
    suspend fun getBoxOffice(date: String): Result<List<BoxOfficeEntity>>
    suspend fun getMovieInfo(code: String): Result<MovieEntity>
    suspend fun getMovies(movieName: String): Result<List<MovieEntity>>
    suspend fun getPeople(peopleName: String): Result<List<PeopleEntity>>
}
package com.twaun95.domain.usecase.movie

import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.movie.MovieEntity
import com.twaun95.domain.repository.movie.MovieRepository
import com.twaun95.domain.usecase.UseCase
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : UseCase {

    suspend operator fun invoke(movieName: String): Result<List<MovieEntity>> {
        return movieRepository.getMovies(movieName)
    }
}
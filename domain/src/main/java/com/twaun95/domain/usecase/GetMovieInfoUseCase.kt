package com.twaun95.domain.usecase

import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.MovieEntity
import com.twaun95.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieInfoUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        code: String
    ) : Result<MovieEntity> {
        return movieRepository.getMovieInfo(code)
    }
}
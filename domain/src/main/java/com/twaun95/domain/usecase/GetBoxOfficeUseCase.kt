package com.twaun95.domain.usecase

import com.twaun95.domain.model.MovieEntity
import com.twaun95.domain.model.Result
import com.twaun95.domain.repository.MovieRepository
import javax.inject.Inject

class GetBoxOfficeUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(
        key: String,
        date: String
    ) : Result<List<MovieEntity>> {
        return movieRepository.getBoxOffice(key, date)
    }
}
package com.twaun95.domain.usecase.movie

import com.twaun95.domain.model.entity.movie.BoxOfficeEntity
import com.twaun95.domain.model.Result
import com.twaun95.domain.repository.movie.MovieRepository
import com.twaun95.domain.usecase.UseCase
import javax.inject.Inject

class GetBoxOfficeUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : UseCase {

    suspend operator fun invoke(
        date: String
    ): Result<List<BoxOfficeEntity>> {
        return movieRepository.getBoxOffice(date)
    }
}
package com.twaun95.domain.usecase.people

import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.movie.PeopleEntity
import com.twaun95.domain.repository.movie.MovieRepository
import com.twaun95.domain.usecase.UseCase
import javax.inject.Inject

class SearchPeopleUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : UseCase {

    suspend operator fun invoke(
        peopleName: String
    ): Result<List<PeopleEntity>> {
        return movieRepository.getPeople(peopleName)
    }
}
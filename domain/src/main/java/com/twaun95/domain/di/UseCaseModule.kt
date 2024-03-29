package com.twaun95.domain.di

import com.twaun95.domain.repository.movie.MovieRepository
import com.twaun95.domain.usecase.movie.GetBoxOfficeUseCase
import com.twaun95.domain.usecase.movie.GetMovieDetailUseCase
import com.twaun95.domain.usecase.movie.SearchMoviesUseCase
import com.twaun95.domain.usecase.people.SearchPeopleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providesGetBoxOfficeUseCase(repository: MovieRepository): GetBoxOfficeUseCase {
        return GetBoxOfficeUseCase(repository)
    }

    @Singleton
    @Provides
    fun providesGetMovieDetailUseCase(repository: MovieRepository): GetMovieDetailUseCase {
        return GetMovieDetailUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSearchMoviesUseCase(repository: MovieRepository): SearchMoviesUseCase {
        return SearchMoviesUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSearchPeopleUseCase(repository: MovieRepository): SearchPeopleUseCase {
        return SearchPeopleUseCase(repository)
    }
}
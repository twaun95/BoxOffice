package com.twaun95.domain.di

import com.twaun95.domain.repository.movie.MovieRepository
import com.twaun95.domain.usecase.movie.GetBoxOfficeUseCase
import com.twaun95.domain.usecase.movie.GetMovieInfoUseCase
import com.twaun95.domain.usecase.movie.SearchMoviesUseCase
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
    fun providesGetMovieInfoUseCase(repository: MovieRepository): GetMovieInfoUseCase {
        return GetMovieInfoUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSearchMoviesUseCase(repository: MovieRepository): SearchMoviesUseCase {
        return SearchMoviesUseCase(repository)
    }
}
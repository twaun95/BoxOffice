package com.twaun95.domain.di

import com.twaun95.domain.repository.MovieRepository
import com.twaun95.domain.usecase.GetBoxOfficeUseCase
import com.twaun95.domain.usecase.GetMovieInfoUseCase
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
}
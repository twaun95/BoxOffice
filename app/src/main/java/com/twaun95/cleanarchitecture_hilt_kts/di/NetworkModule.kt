package com.twaun95.cleanarchitecture_hilt_kts.di

import com.twaun95.cleanarchitecture_hilt_kts.BuildConfig
import com.twaun95.data.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val API_KEY = BuildConfig.API_KEY
    private const val BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest"

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideBoxOffice(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}
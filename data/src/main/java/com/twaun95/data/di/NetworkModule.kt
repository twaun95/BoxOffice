package com.twaun95.data.di

import com.google.gson.GsonBuilder
import com.twaun95.data.BuildConfig
import com.twaun95.data.model.APIKey
import com.twaun95.data.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/"
    private const val TIME_OUT_COUNT : Long = 30

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor {
                it.proceed(
                    it.request()
                        .newBuilder()
                        .build()
                ).also { response ->
                    Timber.d("Response Code: ${response.code}")
                    Timber.d("Response IsSuccessFul: ${response.isSuccessful}")
                    Timber.d("Response Body: ${response.peekBody(4096).string()}")
                }
            }
            .connectTimeout(TIME_OUT_COUNT, TimeUnit.SECONDS)
            .readTimeout(300, TimeUnit.SECONDS)
            .writeTimeout(300, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                GsonBuilder().serializeNulls().create()
            ))
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun getAPIKey(): APIKey {
        return APIKey(key = BuildConfig.API_KEY)
    }

    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}
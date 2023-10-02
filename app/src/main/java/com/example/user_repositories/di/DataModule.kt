package com.example.user_repositories.di

import com.example.user_repositories.data.RepositoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun providesHttpClient(): OkHttpClient{
    return OkHttpClient.Builder()
        .addInterceptor { chain ->
            val newRequest = chain.request().newBuilder().addHeader(
                "Authorization", "Bearer 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"
            ).build()
            chain.proceed(newRequest)
        }
        .build()}
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun providesRepositoriesService(retrofit: Retrofit): RepositoriesService {
        return retrofit.create(RepositoriesService::class.java)
    }
}
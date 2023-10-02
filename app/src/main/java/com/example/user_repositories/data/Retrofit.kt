package com.example.user_repositories.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val client = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val newRequest = chain.request().newBuilder().addHeader(
            "Authorization", "Bearer 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"
        ).build()
        chain.proceed(newRequest)
    }
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://api.github.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
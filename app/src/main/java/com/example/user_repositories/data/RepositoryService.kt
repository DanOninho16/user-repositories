package com.example.user_repositories.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoriesService {
    @GET("/users/{user}/repos")
    suspend fun searchRepositories(@Path("user")searchQuery: String): Response<List<Repository>>
}

val repositoriesService = retrofit.create(RepositoriesService::class.java)

val repositories = listOf(
    "DanOninho16",
    "Pedro",
    "GrandeOnde",
    "CorreaHugo",
)
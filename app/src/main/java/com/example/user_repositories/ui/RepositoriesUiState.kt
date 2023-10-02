package com.example.user_repositories.ui

import com.example.user_repositories.data.Repository

data class RepositoriesUiState (
    val repositories: List<Repository> = listOf(),
    val error: String? = null
)
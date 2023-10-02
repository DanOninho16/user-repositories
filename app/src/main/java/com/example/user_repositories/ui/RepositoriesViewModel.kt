package com.example.user_repositories.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.user_repositories.data.RepositoriesService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RepositoriesViewModel @Inject constructor(private val repositoriesService: RepositoriesService) : ViewModel() {
    private val _repositoriesState = MutableStateFlow(RepositoriesUiState())
    val repositoriesUiState: StateFlow<RepositoriesUiState>
        get() = _repositoriesState

    init{
        searchRepositories()
    }
    fun searchRepositories() {
        viewModelScope.launch {
            try {
                val response = repositoriesService.searchRepositories("DanOninho16")
                if (response.isSuccessful) {
                    Log.d("Repositórios", "Busca bem-sucedida")
                    Log.d("Repositórios", response.body().toString())
                    _repositoriesState.update { currentState ->
                        currentState.copy(
                            repositories = response.body() ?: listOf()
                        )
                    }
                } else {
                    Log.e("Repositórios", "Erro na solicitação: ${response.code()}")
                    _repositoriesState.update { currentState ->
                        currentState.copy(
                            error = "Erro na solicitação"
                        )
                    }
                }
            } catch (e: Exception) {
                Log.e("Repositórios", "Erro na rede: ${e.message}")
                _repositoriesState.update { currentState ->
                    currentState.copy(
                        error = "Erro de rede: ${e.message}"
                    )
                }
            }
        }
    }
}
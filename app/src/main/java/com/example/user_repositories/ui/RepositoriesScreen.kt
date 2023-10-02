package com.example.user_repositories.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.user_repositories.data.Repository

@Composable
fun Repository(repository: Repository, modifier: Modifier = Modifier) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(125.dp)
        .padding(vertical = 2.dp, horizontal = 5.dp), ) {
        Column{
            Text(
                text = "Nome: ${repository.name}",
                modifier = Modifier.padding(3.dp)
            )
            repository.description?.let {
                Text(
                    text = "Descrição: $it",
                    modifier = modifier.padding(3.dp)
                )
            }
            Text(
                text = "Url: ${repository.url}",
                modifier = modifier.padding(3.dp)
            )
        }
    }
}

@Composable
fun RepositoriesList(
    modifier: Modifier = Modifier,
    repositoriesViewModel: RepositoriesViewModel = viewModel()
) {
    val repositoriesState by repositoriesViewModel.repositoriesUiState.collectAsState()
    Column {
        repositoriesState.repositories.forEach { repository ->
            Repository(repository = repository)
        }
    }
}
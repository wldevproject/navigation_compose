package com.cnd.navigationcompose.ui.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            HomeTopBar(
                query = state.query,
                onQueryChange = viewModel::onSearchChange,
                onCreate = viewModel::onCreateNote
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(state.notes) { note ->
                NoteItem(
                    note = note,
                    onEdit = { viewModel.onEdit(note) },
                    onDelete = { viewModel.onDelete(note) }
                )
            }
        }
    }
}

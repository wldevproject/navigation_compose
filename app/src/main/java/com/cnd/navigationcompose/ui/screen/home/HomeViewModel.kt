package com.cnd.navigationcompose.ui.screen.home

import androidx.lifecycle.ViewModel
import com.cnd.navigationcompose.ui.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class HomeUiState(
    val notes: List<Note> = emptyList(),
    val query: String = ""
)

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState(
            notes = dummyNotes()
        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState

    fun onSearchChange(query: String) {
        _uiState.update { it.copy(query = query) }
    }

    fun onCreateNote() {
        // nanti navigate ke Create screen
    }

    fun onEdit(note: Note) {
        // nanti navigate ke Edit screen
    }

    fun onDelete(note: Note) {
        _uiState.update { state ->
            state.copy(
                notes = state.notes.filterNot { it.id == note.id }
            )
        }
    }
}

/* -------------------- DUMMY DATA -------------------- */

private fun dummyNotes(): List<Note> {
    val now = System.currentTimeMillis()
    return listOf(
        Note(1, "Belajar Compose", "State, recomposition, dan layout", now),
        Note(2, "Meeting", "Diskusi roadmap Q1", now - 86_400_000),
        Note(3, "Ide App", "Notes app dengan Compose", now - 172_800_000)
    )
}

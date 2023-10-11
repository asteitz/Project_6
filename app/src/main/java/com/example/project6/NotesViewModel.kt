package com.example.project6;
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NotesViewModel(val dao: NoteDao) : ViewModel() {
    /**
     * NotesViewModel's purpose is to get the data from the database and to communicate to the
     * dao to either insert, delete or update the data passed into the function
     *
     * @param dao the database we are working with
     * return calls to dao on the required command (insert, delete, update)
     * */
    val notes = dao.getAll()
    private val _navigateToNote = MutableLiveData<Long?>()
    val navigateToNote: LiveData<Long?>
        get() = _navigateToNote

    var noteTitle = ""
    var noteBody = ""
    fun addNote() {
        /**
         * AddNotes takes the note objects title and body and inserts the value into the database
         */
        viewModelScope.launch {
            var note = Note()
            note.noteTitle = noteTitle
            note.noteBody = noteBody
            val id = dao.insert(note)
            _navigateToNote.value = id
        }
    }

    fun onNoteClicked(noteId: Long) {
        _navigateToNote.value = noteId
    }

    fun onNoteNavigated() {
        _navigateToNote.value = null
    }

    fun deleteNote(noteId: Long) {
        /**
         * retrieves the noteId from the note obejct and calls delete on that id in the database
         */
        viewModelScope.launch {
            val note = Note()
            note.noteId = noteId
            dao.delete(note)
            _navigateToNote.value = null
        }
    }
}

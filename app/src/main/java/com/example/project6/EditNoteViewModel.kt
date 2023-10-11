package com.example.project6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume



    class EditNoteViewModel(noteId: Long, val dao: NoteDao) : ViewModel() {
        /**
         * NotesViewModel's purpose is to get the data from the database and to communicate to the
         * dao to either insert, delete or update the data passed into the function
         *
         * @param dao the database we are working with
         * @return calls to dao on the required command (insert, delete, update)
         */
        var noteId: Long = noteId
        private val _navigateToList = MutableLiveData<Boolean>(false)
       var note = MutableLiveData<Note>()
        val navigateToList: LiveData<Boolean>
            get() = _navigateToList
        init {
            dao.get(noteId).observeForever{ it ->
                if(it == null) {
                    note.value = Note()
                } else {
                    note.value = it
                }
            }

        }

        fun saveNote() {
            /**
             * The EditNoteViewModel is used when a user either wants to add or update and existing note.
             *
             * The save note function takes the note id and checks if it is in the data base (noteId >= 0)
             * or if it is not already in the database (noteId = -1)
             *
             *
             */
            viewModelScope.launch {
                    if(note.value?.noteId != 0L) {
                        dao.update(note.value!!)
                    } else {
                        dao.insert(note.value!!)
                    }
                    _navigateToList.value = true
            }
        }
        fun dontSaveNote() {
            // if the back button is pressed we do not save the value of the note
            viewModelScope.launch {
                _navigateToList.value = true
            }
        }
        fun onNavigatedToList() {
            _navigateToList.value = false
        }
}
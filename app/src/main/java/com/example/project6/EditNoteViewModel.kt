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

public suspend fun <T> LiveData<T>.await(): T {
    return withContext(Dispatchers.Main.immediate) {
        suspendCancellableCoroutine { continuation ->
            val observer = object : Observer<T> {
                override fun onChanged(value: T) {
                    removeObserver(this)
                    continuation.resume(value)
                }
            }
            observeForever(observer)
            continuation.invokeOnCancellation {
                removeObserver(observer)
            }
        }
    }
}

    class EditNoteViewModel(noteId: Long, val dao: NoteDao) : ViewModel() {
        var title = ""
        var body = ""
        var noteId = noteId

       var note : LiveData<Note>? = null
        init {
            if (noteId != (-1).toLong()) {
                note = dao.get(noteId)
            }
        }

        private val _navigateToList = MutableLiveData<Boolean>(false)
        val navigateToList: LiveData<Boolean>
            get() = _navigateToList
        fun saveNote() {
            viewModelScope.launch {

                if(noteId == (-1).toLong()) {
                    val note = Note()
                    note.noteTitle = title
                    note.noteBody = body
                  dao.insert(note)
                } else {
                    dao.update(note?.value!!)

                }
                _navigateToList.value = true
            }
        }
        fun dontSaveNote() {
            viewModelScope.launch {
                _navigateToList.value = true
            }
        }
        fun onNavigatedToList() {
            _navigateToList.value = false
        }
}
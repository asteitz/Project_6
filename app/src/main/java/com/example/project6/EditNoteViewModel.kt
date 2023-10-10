package com.example.project6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
    class EditNoteViewModel(taskId: Long, val dao: NoteDao) : ViewModel() {
        val note = dao.get(taskId)
        private val _navigateToList = MutableLiveData<Boolean>(false)
        val navigateToList: LiveData<Boolean>
            get() = _navigateToList
        fun saveNote() {
            viewModelScope.launch {
                dao.update(note.value!!)
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
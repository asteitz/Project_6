package com.example.project6;
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksViewModel(val dao: NoteDao) : ViewModel() {
    var newNoteName = ""
    val notes = dao.getAll()
    private val _navigateToTask = MutableLiveData<Long?>()
    val navigateToTask: LiveData<Long?>
        get() = _navigateToTask
    fun addNote() {
        viewModelScope.launch {
            val note = Note()
            note.noteName = newNoteName
            dao.insert(note)
        }
    }
    fun onTaskClicked(taskId: Long) {
        _navigateToTask.value = taskId
    }
    fun onTaskNavigated() {
        _navigateToTask.value = null
    }
}

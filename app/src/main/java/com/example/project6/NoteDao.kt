package com.example.project6
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    /**
     * Used as the interface working with the database to insert, delete and update the main data
     * table holding the notes present
     *
     */
    @Insert
    suspend fun insert(task: Note)
    @Update
    suspend fun update(task: Note)
    @Delete
    suspend fun delete(task: Note)
    @Query("SELECT * FROM task_table WHERE taskId = :key")
    fun get(key: Long): LiveData<Note>
    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
    fun getAll(): LiveData<List<Note>>
}
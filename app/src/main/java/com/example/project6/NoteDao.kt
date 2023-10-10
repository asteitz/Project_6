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
    suspend fun insert(note: Note)
    @Update
    suspend fun update(note: Note)
    @Delete
    suspend fun delete(note: Note)
    @Query("SELECT * FROM notes_table WHERE noteId = :key")
    fun get(key: Long): LiveData<Note>
    @Query("SELECT * FROM notes_table ORDER BY noteId DESC")
    fun getAll(): LiveData<List<Note>>

    @Query("DELETE FROM notes_table")
    fun nukeTable()

}
package com.example.project6;

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var noteId: Long = 0L,
    @ColumnInfo(name = "note_name")
    var noteTitle: String = "",
    @ColumnInfo (name = "body")
    var noteBody: String = "",
    @ColumnInfo(name = "note_done")
    var noteClosed: Boolean = false
)
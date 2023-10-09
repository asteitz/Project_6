package com.example.project6;

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var noteId: Long = 0L,
    @ColumnInfo(name = "task_name")
    var noteTitle: String = "",
    @ColumnInfo (name = "body")
    var noteBody: String = "",
    @ColumnInfo(name = "task_done")
    var noteClosed: Boolean = false
)
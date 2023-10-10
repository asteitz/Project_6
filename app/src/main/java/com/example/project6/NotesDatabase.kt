package com.example.project6

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 5, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
    companion object {
        @Volatile
        private var INSTANCE: NotesDatabase? = null
        fun getInstance(context: Context): NotesDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotesDatabase::class.java,
                        "notes_database_5"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
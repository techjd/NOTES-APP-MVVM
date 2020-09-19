package com.techjd.notesapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.techjd.notesapp.model.Notes

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNotes(notes: Notes)

    @Update
    suspend fun updateNote(notes: Notes)

    @Delete
    suspend fun deleteNote(notes: Notes)



    @Query("SELECT * FROM notes_data ORDER BY id ASC")
    fun readAllNotes(): LiveData<List<Notes>>





}
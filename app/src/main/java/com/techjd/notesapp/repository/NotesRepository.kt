package com.techjd.notesapp.repository

import androidx.lifecycle.LiveData
import com.techjd.notesapp.data.NotesDao
import com.techjd.notesapp.model.Notes

class NotesRepository(private val notesDao: NotesDao) {

    val readAllData: LiveData<List<Notes>> = notesDao.readAllNotes()

    suspend fun addNotes(notes: Notes) {
        notesDao.addNotes(notes)
    }

    suspend fun updateNote(notes: Notes) {
        notesDao.updateNote(notes)
    }

    suspend fun deleteNote(notes: Notes) {
        notesDao.deleteNote(notes)
    }


}
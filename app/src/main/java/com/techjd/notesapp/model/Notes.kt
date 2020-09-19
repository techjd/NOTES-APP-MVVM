package com.techjd.notesapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "notes_data")
data class Notes (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val notesTitle: String,
    val notesDesc: String
): Parcelable
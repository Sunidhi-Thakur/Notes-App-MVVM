package com.sunidhi.notes.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "note"
)
data class UserEntity (
    @PrimaryKey(autoGenerate = true)val id: Int=0,
    val name: String
)




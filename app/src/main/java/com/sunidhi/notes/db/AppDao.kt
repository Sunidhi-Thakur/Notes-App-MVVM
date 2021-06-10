package com.sunidhi.notes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM note ORDER BY id DESC")
    fun getRecord(): List<UserEntity>

    @Insert
    fun insertRecord(userEntity: UserEntity)

}




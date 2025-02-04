package com.example.multipleroomtables

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.multipleroomtables.entities.Director
import com.example.multipleroomtables.entities.School
import com.example.multipleroomtables.entities.SchoolAndDirector

@Dao
interface Dao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirector(schoolName: School): List<SchoolAndDirector>
}
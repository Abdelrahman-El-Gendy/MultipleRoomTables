package com.example.multipleroomtables

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.multipleroomtables.entities.Director
import com.example.multipleroomtables.entities.School
import com.example.multipleroomtables.entities.Student
import com.example.multipleroomtables.relations.SchoolAndDirector
import com.example.multipleroomtables.relations.SchoolWithStudents

@Dao
interface Dao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: School): List<SchoolAndDirector>


    @Transaction
    @Query("SELECT * FROM school WHERE schoolName=:schoolName")
    suspend fun getSchoolAndStudents(schoolName: School): List<SchoolWithStudents>
}
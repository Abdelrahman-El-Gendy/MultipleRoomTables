package com.example.multipleroomtables.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.multipleroomtables.entities.Student
import com.example.multipleroomtables.entities.Subject

@Entity
data class StudentsWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossReference::class)
    )
    val subject: List<Subject>
)

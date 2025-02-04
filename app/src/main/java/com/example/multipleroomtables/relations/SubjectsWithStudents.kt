package com.example.multipleroomtables.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.multipleroomtables.entities.Student
import com.example.multipleroomtables.entities.Subject


@Entity
data class SubjectsWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossReference::class)
    )
    val student: List<Student>
)

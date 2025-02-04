package com.example.multipleroomtables.relations

import androidx.room.Entity

@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentSubjectCrossReference(
    val studentName: String,
    val subjectName: String
)

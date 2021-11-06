package com.mindorks.kotlinlecture4.services

import com.mindorks.kotlinlecture4.model.ApiStudent

class NetworkService {

    fun getTopperStudent() = ApiStudent("Aamir", "Khan", 90)

    fun getListOfStudent(): List<ApiStudent> {
        val listOfStudent = listOf(
            ApiStudent("Aamir", "Khan", 90),
            ApiStudent("Amit", "Shekar", 90),
            ApiStudent("Janisar", "Ali", 90),
            ApiStudent("Anand", "Gaurav", 90)
        )

        return listOfStudent
    }

    fun getStudentClassWise(): Map<String, List<ApiStudent>> {

        val classAStudents = listOf(
            ApiStudent("Aamir", "Khan", 90),
            ApiStudent("Amit", "Shekar", 90)
        )

        val classBStudents = listOf(
            ApiStudent("Janisar", "Ali", 90),
            ApiStudent("Anand", "Gaurav", 90)
        )

        val classWiseStudent = mapOf(
            "ClassA" to classAStudents,
            "ClassB" to classBStudents
        )

        return classWiseStudent
    }
}
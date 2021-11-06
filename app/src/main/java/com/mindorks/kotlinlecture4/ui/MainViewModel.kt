package com.mindorks.kotlinlecture4.ui

import android.content.Context
import com.mindorks.kotlinlecture4.mapper.StudentMapper
import com.mindorks.kotlinlecture4.model.Student
import com.mindorks.kotlinlecture4.services.NetworkService
import com.mindorks.kotlinlecture4.util.NetworkUtils

class MainViewModel(val networkService: NetworkService) {

    fun getTopperStudent(context: Context): Student? {

        val isInternetConnected = NetworkUtils.isInternetConnected(context)
        val student: Student?

        if (isInternetConnected) {
            val apiStudent = networkService.getTopperStudent()
            student = StudentMapper.getInstance().map(apiStudent)
        } else {
            student = null
        }

        return student
    }

    fun getListOfStudent(context: Context): List<Student> {

        val isInternetConnected = NetworkUtils.isInternetConnected(context)
        val studentList: MutableList<Student> = mutableListOf()

        if (isInternetConnected) {

            val listApiStudent = networkService.getListOfStudent()

            for (apiStudent in listApiStudent) {

                val student = StudentMapper.getInstance().map(apiStudent)

                studentList.add(student)
            }

        }

        return studentList
    }

    fun getStudentGrade(averageMark: Int): String {
        val grade: String

        when (averageMark) {
            in 95..99 -> grade = "A"
            100 -> grade = "A+"
            in 90..94 -> grade = "B"
            else -> grade = "C"
        }
        
        return grade
    }

}
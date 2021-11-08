package com.mindorks.kotlinlecture4.mapper

import com.mindorks.kotlinlecture4.model.ApiStudent
import com.mindorks.kotlinlecture4.model.Student

/****
 * Author: Ahmed Yehya
 * Email: ahmedyehya1992@gmail.com
 * Created on: 11/7/21
 *****/
object StudentMapper {
    fun map(apiStudent: ApiStudent): Student {
        return Student(apiStudent.firsName+" " + apiStudent.lastName, apiStudent.averageMark)
    }
}
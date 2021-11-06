package com.mindorks.kotlinlecture4.mapper;

import com.mindorks.kotlinlecture4.model.ApiStudent;
import com.mindorks.kotlinlecture4.model.Student;

public class StudentMapper {

    private static StudentMapper INSTANCE;

    private StudentMapper() {

    }


    public static StudentMapper getInstance() {

        if (INSTANCE == null) {
            synchronized (Student.class) {
                if (INSTANCE == null) {
                    INSTANCE = new StudentMapper();
                }
            }
        }

        return INSTANCE;
    }


    public Student map(ApiStudent apiStudent) {
        return new Student(
                apiStudent.getFirsName() + " " + apiStudent.getLastName(),
                apiStudent.getAverageMark()
        );
    }
}

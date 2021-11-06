package com.mindorks.kotlinlecture4.model;

import java.util.Objects;

public class Student {

    private String userName;
    private int averageMark;

    public Student(String userName, int averageMark) {
        this.userName = userName;
        this.averageMark = averageMark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(int averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "Student {" +
                "userName" + userName +
                "averageMarks" + averageMark +
                "}";
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return averageMark == student.averageMark &&
                Objects.equals(userName, student.userName);
    }

    @Override
    public int hashCode() {

        int result = 1;

        result = 31 * result + (userName == null ? 0 : userName.hashCode());

        result = 31 * result + averageMark;

        return result;
    }
}

package com.company.institut;

public class Student {
    public String name;
    public String secondName;
    public int numberOfExamBook;
    public int avgPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getNumberOfExamBook() {
        return numberOfExamBook;
    }

    public void setNumberOfExamBook(int numberOfExamBook) {
        this.numberOfExamBook = numberOfExamBook;
    }

    @Override
    public String toString() {
        return name + " " + secondName+ " " +avgPoints;
    }

    public int getAvgPoints() {
        return avgPoints;
    }

    public void setAvgPoints(int avgPoints) {
        this.avgPoints = avgPoints;
    }

    public Student(String name, String secondName, int numberOfExamBook, int avgPoints) {
        this.name = name;
        this.secondName = secondName;
        this.numberOfExamBook = numberOfExamBook;
        this.avgPoints = avgPoints;
    }
}

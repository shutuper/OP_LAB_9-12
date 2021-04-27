package com.company.institut;

import java.util.ArrayList;

public class Faculty {
    public String name;
    ArrayList<Student> students;

    @Override
    public String toString() {
        return "Faculty name: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Faculty(String name, ArrayList<Student> students) {
        this.name = name;
        this.students = students;
    }
}

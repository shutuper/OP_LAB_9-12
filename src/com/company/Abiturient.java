package com.company;

public class Abiturient {
    public String SecondName;
    public int points;

    public Abiturient(String secondName, int points) {
        SecondName = secondName;
        this.points = points;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return SecondName + " " + points;
    }
}

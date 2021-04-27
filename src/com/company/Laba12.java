package com.company;

import com.company.institut.Faculty;
import com.company.institut.Institute;
import com.company.institut.Student;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Laba12 {
    static ArrayList<Abiturient> abiturients = new ArrayList<>();
    static ArrayList<Abiturient> abiturientsUnLucky = new ArrayList<>();
    static ArrayList<Student> studentsFICT = new ArrayList<>();
    static ArrayList<Student> studentsIPSA = new ArrayList<>();
    static ArrayList<Faculty> faculties = new ArrayList<>();
    static AtomicInteger limitOfPlace = new AtomicInteger(60);
    static AtomicInteger avgInstitutePoints = new AtomicInteger(0);

    public static void main(String[] args) {
        Laba12.tackChooser(3);

    }

    public static void tackChooser(int i) {
        switch (i) {
            case 1 -> task11(false);
            case 2 -> task22();
            case 3 -> task11(true);
        }
    }

    public static void task11(Boolean task3) {
        // task 1.1

        try (BufferedReader bf = new BufferedReader(new FileReader("src/com/company/list of 2-d names.txt"))) {
            bf.lines().forEach(x -> abiturients.add(new Abiturient(x, new Random().nextInt(101))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("task 1.1");
        abiturients.stream().filter(x -> x.getPoints() > 60)
                .sorted(Comparator.comparing(Abiturient::getPoints).reversed())
                .limit(limitOfPlace.get()).sorted(Comparator.comparing(Abiturient::getSecondName))
                .forEach(System.out::println);
        if (task3) {
            System.out.println("======================================================================");
            System.out.println("task 3.2");
            List<String> unluckyStudents = abiturients.stream().filter(x -> x.getPoints() < 60)
                    .map(Abiturient::getSecondName).collect(Collectors.toList());
            unluckyStudents.forEach(System.out::println);
        }
    }

    public static void task22() {
        // task 2.2

        try (BufferedReader bf = new BufferedReader(new FileReader("src/com/company/institut/list of students.txt"))) {
            bf.lines().forEach(x -> {
                studentsFICT.add(new Student(x.split(" ")[1], x.split(" ")[0],
                        new Random().nextInt(1000000), new Random().nextInt(101)));
                studentsIPSA.add(new Student(x.split(" ")[1], x.split(" ")[0],
                        new Random().nextInt(1000000), new Random().nextInt(101)));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        Faculty FICT = new Faculty("ФІОТ", studentsFICT);
        Faculty IPSA = new Faculty("ІПСА", studentsIPSA);
        faculties.addAll(Arrays.asList(FICT, IPSA));
        Institute KPI = new Institute("КПІ", faculties);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        avgInstitutePoints.set(KPI.getFaculties().stream().map(Faculty::getStudents).flatMap(x -> x.stream().map(Student::getAvgPoints))
                .collect(Collectors.averagingInt(x -> x)).intValue());
        // KPI.getFaculties().stream().map(Faculty::getStudents).flatMap(q -> q.stream().map(Student::getAvgPoints))
        //                .collect(Collectors.averagingInt(z -> z)).intValue()
        System.out.println("Середній бал по інституту: " + avgInstitutePoints.get());
        KPI.getFaculties().stream().map(Faculty::getStudents).flatMap(Collection::stream).filter(x -> x.getAvgPoints() > avgInstitutePoints.get())
                .forEach(System.out::println);

    }

}

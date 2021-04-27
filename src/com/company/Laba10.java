package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static java.lang.Math.*;

public class Laba10 {
    @FunctionalInterface
    interface Function {
        double func(double a, double b, double c, double d);
    }

    public static void main(String[] args) throws NotFoundModuleException {
        // 1 task
        System.out.println("1 task: ");
        Function function;
        function = (a, b, c, d) -> pow(tan(a), 1 / c) / (1 + (sinh(b) / log(abs(d + c))));
        System.out.println("Result: " + function.func(1, 1, 1, 1));

        // 2 task
        System.out.println("2 task: ");
        Phone phone = new SmartPhone("Egora telephon");
        phone.setPhoneNumber("+380-10-412-9715");
        Phone phone1 = new SmartPhone("Ivana telephon");
        phone1.setPhoneNumber("+380-12-412-3456");
        Phone phone2 = new SmartPhone("Azata telephon");
        phone2.setPhoneNumber("+380-12-412-9090");
        Phone phone3 = new SmartPhone("Nasti telephon");
        phone3.setPhoneNumber("+380-11-412-9715");
        ArrayList<Phone> phoneArrayList = new ArrayList<>(Arrays.asList(phone, phone1, phone2, phone3));
        phoneArrayList.sort(Comparator.comparing(Phone::getPhoneNumber));
        phoneArrayList.stream().map(Phone::getPhoneNumber).forEach(System.out::println);
        phoneArrayList.forEach(System.out::println);
    }
}

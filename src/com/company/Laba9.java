package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class Laba9 {


    public static void main(String[] args) throws NotFoundModuleException {

        Phone p = new SmartPhone("Huawei P smart Z");
        p.setPhoneNumber("+380-50-617-0543");
        Phone p1 = new SmartPhone("Huawei P1 smart Z");
        p1.setPhoneNumber("+380-60-617-0543");
        Phone p2 = new SmartPhone("1uawei P2 smart Z");
        p2.setPhoneNumber("+380-70-617-0543");
        Phone p3 = new SmartPhone("Huawei 3P smart Z");
        p3.setPhoneNumber("+380-10-617-0543");
        Phone p4 = new SmartPhone("Lolka 32P sZ");
        p4.setPhoneNumber("+380-10-617-0543");
        Phone p5 = null;

        /*    ====================================================    */
        // 8 лабка
        /*    ====================================================    */
        // 1 завдання
        System.out.println("1 Task");
        TreeSet<Phone> phoneTreeSet = new TreeSet<>(Comparator.comparing(o -> o.phoneNumber));
        phoneTreeSet.add(p);
        phoneTreeSet.add(p1);
        phoneTreeSet.add(p2);
        phoneTreeSet.add(p3);
        phoneTreeSet.add(p4);
        phoneTreeSet.stream().map(x -> x.phoneNumber).forEach(System.out::println);
        /*    ====================================================    */
        // 2 завдання
        /*    ====================================================    */
        System.out.println("2 Task");
        TreeSet<Phone> phoneTreeSet1 = new TreeSet<>(Comparator.comparing((Phone o) -> o.phoneNumber).reversed());
        phoneTreeSet1.add(p);
        phoneTreeSet1.add(p1);
        phoneTreeSet1.add(p2);
        phoneTreeSet1.add(p3);
        phoneTreeSet1.add(p4);
        phoneTreeSet1.stream().map(x -> x.phoneNumber).forEach(System.out::println);
        /*    ====================================================    */
        // 3 завдання
        /*    ====================================================    */
        System.out.println("3 Task");
        TreeSet<Phone> phoneTreeSet2 = new TreeSet<>(Comparator.comparing((Phone o) -> o.phoneNumber).thenComparing(Phone::getModel));
        phoneTreeSet2.add(p);
        phoneTreeSet2.add(p1);
        phoneTreeSet2.add(p2);
        phoneTreeSet2.add(p3);
        phoneTreeSet2.add(p4);
        phoneTreeSet2.stream().map(x -> x.getModel() + " " + x.phoneNumber).forEach(System.out::println);
        /*    ====================================================    */
        // 4 завдання
        /*    ====================================================    */
        System.out.println("4 Task");
        ArrayList<Phone> phoneArrayList = new ArrayList<>();
        phoneArrayList.add(p);
        phoneArrayList.add(p1);
        phoneArrayList.add(p2);
        phoneArrayList.add(p3);
        phoneArrayList.add(p4);
        phoneArrayList.add(p5);
        phoneArrayList.sort(Comparator.nullsFirst(Comparator.comparing(Phone::getModel)));
        phoneArrayList.stream().map(x -> x == null ? "null" : x.model).forEach(System.out::println);
    }
}
//        // ====================================================
//        Main main = new Main();
//        main.phonesAddedWithStaticComparator.add(p);
//        main.phonesAddedWithStaticComparator.add(p1);
//        main.phonesAddedWithStaticComparator.add(p2);
//        main.phonesAddedWithStaticComparator.add(p3);
//        System.out.println("=============================================");
//        System.out.println("Sorted TreeSet: (by number of telephone)");
//        main.phonesAddedWithStaticComparator.forEach(x -> System.out.println(x.model + " " + x.phoneNumber));
//        System.out.println("=============================================");
//        main.phones[0] = p;
//        main.phones[1] = p1;
//        main.phones[2] = p2;
//        main.phones[3] = p3;
//        System.out.println("Unsorted massive: ");
//        Arrays.stream(main.phones).forEach(x -> System.out.println(x.model + " " + x.phoneNumber));
//        System.out.println("=============================================");
//        main.arrayList.sort(phoneComparator);
//        System.out.println("Sorted massive: (by model and number of telephone)");
//        main.arrayList.forEach(x -> System.out.println(x.model + " " + x.phoneNumber));
//        System.out.println("=============================================");
//        Arrays.sort(main.phones, phoneComparator);
//        Arrays.stream(main.phones).forEach(x -> System.out.println(x.model + " " + x.phoneNumber));
//        System.out.println("=============================================");

//    public TreeSet<Phone> phonesAddedWithStaticComparator = new TreeSet<>(new Comparator<Phone>() {
//        @Override
//        public int compare(Phone o1, Phone o2) {
//            if (o1.phoneNumber != null && o2.phoneNumber != null)
//                return o1.phoneNumber.compareTo(o2.phoneNumber);
//            else return o1.model.compareTo(o2.model);
//        }
//    });
//    static Comparator<Phone> phoneComparator = new PhoneComparator();
//    ArrayList<Phone> arrayList = new ArrayList<>();
//    Phone[] phones = new Phone[4];
//
//    static class PhoneComparator implements Comparator<Phone> {
//
//        @Override
//        public int compare(Phone o1, Phone o2) {
//            return o1.model.compareTo(o2.model) + o1.phoneNumber.compareTo(o2.phoneNumber);
//        }
//
//    }
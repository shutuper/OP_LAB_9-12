package com.company;

import java.util.function.Consumer;

public class Laba11 {

    public static void main(String[] args) throws NotFoundModuleException {
        SmartPhone phone = new SmartPhone("ZTE BLADE V8 LITE");
        phone.setPhoneNumber("+380-12-412-9090");
        // 2 task
        //                                     \/
        Consumer<String> moduleConsumer = phone::setPhoneNumber;
        moduleConsumer.accept("+380-11-111-1111");
        // 1 task
        //                         \/
        PrinterSt printerSt = Phone::showExampleNumber;
        System.out.println(printerSt.printer());
        // 3 task
        //                     \/
        Printer printer = Phone::getPhoneNumber;
        System.out.println(printer.printer(phone));
        // 4 task
        //                                              \/
        SmartPhoneCreator smartPhoneCreator = SmartPhone::new;
        SmartPhone myNewPhone = smartPhoneCreator.newName("IPHON");
        System.out.println(myNewPhone.getModel());

    }

}

//class ClassOperation {
//    void operation(NumberSetter setter, SmartPhone smartPhone, String number) throws NotFoundModuleException {
//        setter.newNumber(smartPhone, number);
//    }
//
//    ClassOperation(NumberSetter setter, SmartPhone smartPhone, String number) throws NotFoundModuleException {
//        operation(setter, smartPhone, number);
//    }
//}
//                           \/
//new ClassOperation(SmartPhone::setPhoneNumber, phone, "+380-11-111-1111");
// System.out.println(phone.phoneNumber);
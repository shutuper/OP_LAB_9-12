package com.company;

@FunctionalInterface
interface Printer {
    String printer(Phone phone);
}

@FunctionalInterface
interface PrinterSt {
    String printer();
}

@FunctionalInterface
interface NumberSetter {
    void newNumber(SmartPhone smartPhone, String string) throws NotFoundModuleException;
}
@FunctionalInterface
interface SmartPhoneCreator {
    SmartPhone newName(String string);
}
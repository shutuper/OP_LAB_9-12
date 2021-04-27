package com.company;

import java.util.List;

public abstract class Phone {

    protected String model;
    protected String phoneNumber;
    protected List<Module> modules;

    /**
     * The method must be used to simulate a call
     *
     * @throws NotFoundModuleException if there are no functions in any of the modules.
     */

    public abstract void call(String number) throws NotFoundModuleException;

    /**
     * The method must be used to simulate a charging
     *
     * @throws NotFoundModuleException if there are no functions in any of the modules.
     */

    public abstract void charging() throws NotFoundModuleException;

    /**
     * @return the phoneNumber.
     */

    final public String getPhoneNumber() {
        if (!isBuiltInFunction("phone call")) new NotFoundModuleException();
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set. (For example, "+380-50-617-0543").
     * @throws NotFoundModuleException  if there are no phone call or internet access functions.
     * @throws IllegalArgumentException if not a number is entered.
     */

    final public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    /**
     * @param phoneNumber is the number to check.
     * @return if this number entry - true, otherwise - false.
     */
    protected boolean checkNumber(String phoneNumber) {
        final int length = 12;
        if (!(phoneNumber.charAt(0) >= '0' || phoneNumber.charAt(0) <= '9' || phoneNumber.charAt(0) == '+')) {
            return false;
        }
        phoneNumber = phoneNumber.charAt(0) == '+' ? phoneNumber.substring(1, phoneNumber.length()) : phoneNumber;
        String[] nums = phoneNumber.split("-");
        int c = 0;
        for (String s : nums) {
            for (int i = 0; i < s.length(); i++) {
                if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) return false;
                c++;
            }
        }
        return c == length;
    }

    /**
     * looking for a function in modules.
     *
     * @param name is the name of the function to be found in the phone modules.
     * @return if such a function exists, then it returns true, otherwise - false.
     */

    final public boolean isBuiltInFunction(String name) {
        boolean exist = false;
        label:
        for (Module m : modules) {
            for (Function n : m.getFunctional()) {
                if (n.getName().equals(name)) {
                    exist = true;
                    break label;
                }
                ;
            }
        }
        return exist;
    }

    /**
     * @return the modules.
     */

    final public List<Module> getModules() {
        return modules;
    }

    /**
     * @param modules the modules to set.
     */

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }


    /**
     * @return the model.
     */

    public String getModel() {
        return model;
    }


    /**
     * @param model the model to set.
     */

    public void setModel(String model) {
        this.model = model;
    }

    /**
     * add module to list.
     *
     * @param mod added to the list of modules.
     */

    public void addModule(Module mod) {
        modules.add(mod);
    }

    /**
     * add list modules to list.
     *
     * @param mod added to the list of modules.
     */

    public void addAllModules(List<Module> mod) {
        modules.addAll(mod);
    }

    /**
     * remove module from list.
     */

    public void removeModule(Module mod) {
        modules.remove(mod);
    }

    /**
     * remove module from list by index.
     *
     * @param i is index for remove module from the list of modules.
     */

    public void removeModule(int i) {
        modules.remove(i);
    }

    /**
     * Compares two phones by name and list of modules.
     */

    @Override
    public boolean equals(Object phone) {
        return (phone instanceof Phone) &&
                this.model.equals(((Phone) phone).getModel()) &&
                this.getModules().equals((((Phone) phone).getModules()));
    }

    public static String showExampleNumber() {
        return "+380-00-000-0000";
    }

    @Override
    public String toString() {
        String mods = "";
        for (Module f : modules) {
            mods += f.toString() + " ";
        }
        mods = mods.trim().replaceAll(" ", ", ");
        return model + " : " + mods;
    }

}

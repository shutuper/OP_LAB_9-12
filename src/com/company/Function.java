package com.company;

public class Function {

    private String name;
    private int level;

    /**
     * Constructor for creating simple functions
     *
     * @param name  is the function name to set.
     * @param level indicates the quality of the given function.
     * @throws InvalidLevelException the higher the level, the better the quality. Varies from 1 to 5 inclusive.
     */

    public Function(String name, int level) throws InvalidLevelException {
        super();
        this.name = name;
        if (level < 1 || level > 5) throw new InvalidLevelException(level);
        this.level = level;
    }

    /**
     * Constructor for creating simple functions. The quality level is set to the minimum (1).
     *
     * @param name is the function name to set.
     */

    public Function(String name) {
        super();
        this.name = name;
        this.level = 1;
    }

    public void setPhoneNumberFunc(Phone phone, String phoneNumber) throws NotFoundModuleException {
        phone.phoneNumber = phoneNumber;
    }

    /**
     * @return function name.
     */

    public String getName() {
        return name;
    }

    /**
     * @param name is the function name to set.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the level of function.
     */

    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set.
     */

    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Compares two functions by name.
     */

    @Override
    public boolean equals(Object func) {
        return (func instanceof Function) &&
                this.name.equals(((Function) func).getName());
    }

    @Override
    public String toString() {
        return name + " " + level;
    }
}

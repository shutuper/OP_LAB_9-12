package com.company.institut;

import java.util.ArrayList;

public class Institute {
    public String name;
    ArrayList<Faculty> faculties;

    @Override
    public String toString() {
        return "Institute name: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Institute(String name, ArrayList<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }
}

package com.martak.adventofcode.universalorbitmap;


public class Orbit {

    private final String name;
    private Orbit parent;

    public Orbit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Orbit getParent() {
        return parent;
    }

    public void setParent(Orbit parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Orbit name " + name;
    }
}

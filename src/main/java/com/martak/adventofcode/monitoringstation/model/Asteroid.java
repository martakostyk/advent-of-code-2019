package com.martak.adventofcode.monitoringstation.model;

public class Asteroid {

    private final int x;
    private final int y;

    public Asteroid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("#(%d,%d)", x, y);
    }
}

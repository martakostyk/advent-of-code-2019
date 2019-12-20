package com.martak.adventofcode.monitoringstation;

public class Asteroid {

    private final int x;
    private final int y;

    Asteroid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("#(%d,%d)", x, y);
    }
}

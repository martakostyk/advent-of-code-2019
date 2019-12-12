package com.martak.adventofcode.spaceimageformat;

public class Layer {

    private int[][] pixels;

    public Layer(int width, int height) {
        this.pixels = new int[height][width];
    }

    public int[][] getPixels() {
        return pixels;
    }
}

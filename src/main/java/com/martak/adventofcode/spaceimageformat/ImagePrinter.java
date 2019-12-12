package com.martak.adventofcode.spaceimageformat;

import java.util.Arrays;
import java.util.List;

public class ImagePrinter {

    public static void print(List<Layer> layers) {
        for (int i = 0; i < layers.size(); i++) {
            System.out.println("Layer " + (i + 1) + ":");
            print(layers.get(i));
        }
    }

    public static void print(Layer layer) {
        int[][] pixels = layer.getPixels();
        for (int[] l : pixels) {
            System.out.println(Arrays.toString(l));
        }
    }
}

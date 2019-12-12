package com.martak.adventofcode.spaceimageformat;

import java.util.Arrays;
import java.util.List;

public class ImagePrinter {
    public static void print(Image image) {
        List<Layer> layers = image.getLayers();
        for (int i = 0; i < layers.size(); i++) {
            System.out.println("Layer " + (i + 1) + ":");
            int[][] pixels = layers.get(i).getPixels();
            System.out.println(Arrays.deepToString(layers.get(i).getPixels()));
        }
    }
}

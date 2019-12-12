package com.martak.adventofcode.spaceimageformat;

import java.util.List;

public class Image {

    private final List<Layer> layers;

    public Image(List<Layer> layers) {
        this.layers = layers;
    }

    public List<Layer> getLayers() {
        return layers;
    }
}

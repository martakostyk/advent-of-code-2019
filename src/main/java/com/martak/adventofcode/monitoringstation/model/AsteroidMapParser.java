package com.martak.adventofcode.monitoringstation.model;

import java.util.ArrayList;
import java.util.List;

public class AsteroidMapParser {

    public static List<Asteroid> parse(List<String> asteroidMap) {
        List<Asteroid> asteroids = new ArrayList<>(asteroidMap.size() * asteroidMap.get(0).length());
        for (int i = 0; i < asteroidMap.size(); i++) {
            String[] line = asteroidMap.get(i).split("");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("#")) {
                    asteroids.add(new Asteroid(j, i));
                }
            }
        }
        return asteroids;
    }
}

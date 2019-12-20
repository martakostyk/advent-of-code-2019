package com.martak.adventofcode.monitoringstation;

import java.util.ArrayList;
import java.util.List;

public class AsteroidMap {

    private final List<Asteroid> asteroids;

    private AsteroidMap(List<Asteroid> asteroids) {
        this.asteroids = asteroids;
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public static AsteroidMap parse(String[] map) {
        List<Asteroid> asteroids = new ArrayList<>(map.length * map[0].length());
        for (int i = 0; i < map.length; i++) {
            String[] line = map[i].split("");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("#")) {
                    asteroids.add(new Asteroid(j, i));
                }
            }
        }
        return new AsteroidMap(asteroids);
    }
}

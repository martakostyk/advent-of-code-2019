package com.martak.adventofcode.monitoringstation;

import com.martak.adventofcode.monitoringstation.model.Asteroid;
import com.martak.adventofcode.monitoringstation.model.AsteroidMapParser;
import com.martak.adventofcode.utils.CsvReader;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MonitoringStation {

    private List<Asteroid> asteroids;

    public MonitoringStation(List<Asteroid> asteroids) {
        this.asteroids = asteroids;
    }

    public static void main(String[] args) {
        List<String> asteroidMap = new CsvReader()
                .read("C:\\Users\\Marta_Kostyk\\workspace\\adventofcode\\src\\main\\resources\\asteroidmap.csv");
        List<Asteroid> asteroids = AsteroidMapParser.parse(asteroidMap);
        MonitoringStation monitoringStation = new MonitoringStation(asteroids);
        Asteroid theBestLocation = monitoringStation.findTheBestLocation();
        monitoringStation.vaporizeAsteroids(theBestLocation);
    }

    public Asteroid findTheBestLocation() {
        Asteroid theBestLocation = null;
        int asteroidDetected = 0;
        for (Asteroid base : asteroids) {
            Map<Float, List<Asteroid>> detectedLines = getDetectedAsteroidLines(base);
            if (detectedLines.keySet().size() > asteroidDetected) {
                theBestLocation = base;
                asteroidDetected = detectedLines.keySet().size();
            }
        }
        System.out.println("The best location for monitoring station: " + theBestLocation);
        System.out.println("Number of detected asteroids: " + asteroidDetected);
        return theBestLocation;
    }

    private Map<Float, List<Asteroid>> getDetectedAsteroidLines(Asteroid base) {
        Map<Float, List<Asteroid>> asteroidLines = new TreeMap<>();
        for (Asteroid asteroid : asteroids) {
            float angle;
            if (!asteroid.equals(base)) {
                angle = calculateAngle(base, asteroid);
                angle = calculateFullAngle(base, asteroid, angle);
                if (!asteroidLines.containsKey(angle)) {
                    List<Asteroid> line = new LinkedList<>();
                    line.add(asteroid);
                    asteroidLines.put(angle, line);
                } else {
                    asteroidLines.get(angle).add(asteroid);
                }
            }
        }
        return asteroidLines;
    }

    public float calculateAngle(Asteroid a1, Asteroid a2) {
        double angle1 = Math.atan2(0, Math.abs(a1.getX() - a2.getX()));
        double angle2 = Math.atan2(Math.abs(a2.getY() - a1.getY()),
                Math.abs(a1.getX() - a2.getX()));
        float angle = Math.abs((float) Math.toDegrees(angle1 - angle2));
        return (angle == 90) ? 0 : angle;
    }

    public float calculateFullAngle(Asteroid base, Asteroid asteroid, float angle) {
        if (asteroid.getX() > base.getX() && asteroid.getY() <= base.getY()) {
            return 90 - angle;
        } else if (asteroid.getX() > base.getX() && asteroid.getY() > base.getY()) {
            return 90 + angle;
        } else if (asteroid.getX() <= base.getX() && asteroid.getY() > base.getY()) {
            return 180 + angle;
        } else if (asteroid.getX() < base.getX() && asteroid.getY() <= base.getY()) {
            return 270 + angle;
        }
        return 0;
    }

    public void vaporizeAsteroids(Asteroid stationLocation) {
        Map<Float, List<Asteroid>> detectedAsteroidLines = getDetectedAsteroidLines(stationLocation);
        long asteroidsToVaporize = detectedAsteroidLines.values()
                .stream()
                .mapToLong(Collection::size)
                .sum();
        long vaporizedAsteroids = 0;
        while (asteroidsToVaporize != vaporizedAsteroids) {
            for (List<Asteroid> line : detectedAsteroidLines.values()) {
                if (line.size() > 0) {
                    System.out.println(String.format("The %d asteroid to be vaporized is at %d, %d",
                            vaporizedAsteroids + 1, line.get(0).getX(), line.get(0).getY()));
                    line.remove(0);
                    vaporizedAsteroids++;
                }
            }
        }
    }
}

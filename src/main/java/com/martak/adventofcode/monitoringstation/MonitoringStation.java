package com.martak.adventofcode.monitoringstation;

import com.martak.adventofcode.monitoringstation.model.Asteroid;
import com.martak.adventofcode.monitoringstation.model.AsteroidMapParser;
import com.martak.adventofcode.utils.CsvReader;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MonitoringStation {

    public final List<Asteroid> asteroids;

    public MonitoringStation(List<Asteroid> asteroids) {
        this.asteroids = asteroids;
    }

    public static void main(String[] args) {
        List<String> asteroidMap = new CsvReader()
                .read("C:\\Users\\Marta_Kostyk\\workspace\\adventofcode\\src\\main\\resources\\asteroidmap.csv");
        List<Asteroid> asteroids = AsteroidMapParser.parse(asteroidMap);
        MonitoringStation monitoringStation = new MonitoringStation(asteroids);
        monitoringStation.findTheBestLocation();
    }

    public Asteroid findTheBestLocation() {
        Asteroid theBestLocation = null;
        int asteroidDetected = 0;
        for (Asteroid base : asteroids) {
            Set<Double> angleDetected = findAngles(base);
            if (angleDetected.size() > asteroidDetected) {
                theBestLocation = base;
                asteroidDetected = angleDetected.size();
            }
        }
        System.out.println("The best location for monitoring station: " + theBestLocation);
        System.out.println("Number of detected asteroids: " + asteroidDetected);
        return theBestLocation;
    }

    private Set<Double> findAngles(Asteroid base) {
        return asteroids.stream()
                .map(asteroid -> {
                    if (!asteroid.equals(base)) {
                        double a = Math.abs(base.getX() - asteroid.getX());
                        double b = Math.abs(base.getY() - asteroid.getY());
                        double angle = Math.atan(b / a);
                        angle = adjustAngle(base, asteroid, angle);
                        return angle;
                    }
                    return -1D;
                }).filter(angle -> angle >= 0)
                .collect(Collectors.toSet());
    }

    private double adjustAngle(Asteroid base, Asteroid asteroid, double angle) {
        if (asteroid.getX() >= base.getX() && asteroid.getY() >= base.getY()) {
            return 270 + angle;
        } else if (asteroid.getX() < base.getX() && asteroid.getY() > base.getY()) {
            return 90 - angle;
        } else if (asteroid.getX() <= base.getX() && asteroid.getY() <= base.getY()) {
            return 90 + angle;
        } else {
            return 270 - angle;
        }
    }
}

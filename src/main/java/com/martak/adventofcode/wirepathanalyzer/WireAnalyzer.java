package com.martak.adventofcode.wirepathanalyzer;

import com.martak.adventofcode.utils.CsvReader;
import com.martak.adventofcode.wirepathanalyzer.model.Command;
import com.martak.adventofcode.wirepathanalyzer.model.CommandParser;
import com.martak.adventofcode.wirepathanalyzer.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class WireAnalyzer {

    private static final String COMA_DELIMITER = ",";

    public static void main(String[] args) {
        WireAnalyzer wireAnalyzer = new WireAnalyzer();
        CsvReader csvReader = new CsvReader();
        String[] commandsA = csvReader.read(
                "C:\\Users\\Marta_Kostyk\\workspace\\adventofcode\\src\\main\\resources\\commandsA.csv").get(0).split(COMA_DELIMITER);
        String[] commandsB = csvReader.read(
                "C:\\Users\\Marta_Kostyk\\workspace\\adventofcode\\src\\main\\resources\\commandsB.csv").get(0).split(COMA_DELIMITER);
        List<Command> pathA = CommandParser.getPath(commandsA);
        List<Command> pathB = CommandParser.getPath(commandsB);
        List<Point> intersections = wireAnalyzer.findIntersections(pathA, pathB);
        System.out.println(wireAnalyzer.getManhattanDistanceOfClosest(intersections));
    }

    public Integer getManhattanDistanceOfClosest(List<Point> intersections) {
        return intersections.stream()
                .map(point -> Math.abs(point.getX()) + Math.abs(point.getY()))
                .sorted()
                .filter(distance -> distance > 0)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Point> findIntersections(List<Command> pathA, List<Command> pathB) {
        List<Point> intersections = new ArrayList<>();
        for (int i = 0; i < pathA.size() ; i++) {
            for (int j = 0; j < pathB.size() ; j++) {
                Point A1 = pathA.get(i).getStart();
                Point A2 = pathA.get(i).getEnd();
                Point B1 = pathB.get(j).getStart();
                Point B2 = pathB.get(j).getEnd();
                int minX = 0;
                int maxX = 0;
                int minY = 0;
                int maxY = 0;
                Point possibleIntersection = null;
                if (A1.getX() == A2.getX() && B1.getY() == B2.getY()) {
                    if (A1.getY() < A2.getY()) {
                        minY = A1.getY();
                        maxY = A2.getY();
                    } else {
                        minY = A2.getY();
                        maxY = A1.getY();
                    }
                    if (B1.getX() < B2.getX()) {
                        minX = B1.getX();
                        maxX = B2.getX();
                    } else {
                        minX = B2.getX();
                        maxX = B1.getX();
                    }
                    possibleIntersection = new Point(A1.getX(), B1.getY());
                } else if (A1.getY() == A2.getY() && B1.getX() == B2.getX()) {
                    if (B1.getY() < B2.getY()) {
                        minY = B1.getY();
                        maxY = B2.getY();
                    } else {
                        minY = B2.getY();
                        maxY = B1.getY();
                    }
                    if (A1.getX() < A2.getX()) {
                        minX = A1.getX();
                        maxX = A2.getX();
                    } else {
                        minX = A2.getX();
                        maxX = A1.getX();
                    }
                    possibleIntersection = new Point(B1.getX(), A1.getY());
                }
                if (possibleIntersection != null && possibleIntersection.getX() >= minX && possibleIntersection.getX() <= maxX
                        && possibleIntersection.getY() >= minY && possibleIntersection.getY() <= maxY) {
                    intersections.add(possibleIntersection);
                }
            }
        }
        return intersections;
    }

}

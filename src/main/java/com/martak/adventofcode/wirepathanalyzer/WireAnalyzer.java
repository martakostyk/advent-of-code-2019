package com.martak.adventofcode.wirepathanalyzer;

import com.martak.adventofcode.utils.CsvReader;
import com.martak.adventofcode.wirepathanalyzer.model.Command;
import com.martak.adventofcode.wirepathanalyzer.model.CommandParser;
import com.martak.adventofcode.wirepathanalyzer.model.Point;

import java.util.*;

import static com.martak.adventofcode.wirepathanalyzer.model.Constants.*;

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
        Map<Point, Integer> intersections = wireAnalyzer.findIntersections(pathA, pathB);
        Integer result = wireAnalyzer.getFewestSteps(intersections);
        System.out.println(result);
    }

    public Integer getFewestSteps(Map<Point, Integer> intersections) {
        return intersections.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .filter(steps -> steps > 0)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Map<Point, Integer> findIntersections(List<Command> pathA, List<Command> pathB) {
        Map<Point, Integer> intersections = new HashMap<>();
        for (int i = 0; i < pathA.size(); i++) {
            Command commandA = pathA.get(i);
            Point A1 = commandA.getStart();
            Point A2 = commandA.getEnd();
            for (int j = 0; j < pathB.size(); j++) {
                Command commandB = pathB.get(j);
                Point B1 = commandB.getStart();
                Point B2 = commandB.getEnd();
                int minX = 0;
                int maxX = 0;
                int minY = 0;
                int maxY = 0;
                Point possibleIntersection = null;
                if ((commandA.getDirection().equals(UP) || commandA.getDirection().equals(DOWN)) &&
                        (commandB.getDirection().equals(LEFT) || commandB.getDirection().equals(RIGHT))) {
                    possibleIntersection = new Point(A1.getX(), B1.getY());
                    if (commandA.getDirection().equals(UP)) {
                        minY = A1.getY();
                        maxY = A2.getY();
                    } else {
                        minY = A2.getY();
                        maxY = A1.getY();
                    }
                    if (commandB.getDirection().equals(RIGHT)) {
                        minX = B1.getX();
                        maxX = B2.getX();
                    } else {
                        minX = B2.getX();
                        maxX = B1.getX();
                    }
                } else if ((commandA.getDirection().equals(LEFT) || commandA.getDirection().equals(RIGHT))
                        && commandB.getDirection().equals(UP) || commandB.getDirection().equals(DOWN)) {
                    possibleIntersection = new Point(B1.getX(), A1.getY());
                    if (commandB.getDirection().equals(UP)) {
                        minY = B1.getY();
                        maxY = B2.getY();
                    } else {
                        minY = B2.getY();
                        maxY = B1.getY();
                    }
                    if (commandA.getDirection().equals(RIGHT)) {
                        minX = A1.getX();
                        maxX = A2.getX();
                    } else {
                        minX = A2.getX();
                        maxX = A1.getX();
                    }
                }

                if (possibleIntersection != null && isWithinRange(minX, maxX, minY, maxY, possibleIntersection)) {
                    Optional<Integer> stepsA = pathA.stream().limit(i).map(Command::getSteps).reduce(Integer::sum);
                    Optional<Integer> stepsB = pathB.stream().limit(j).map(Command::getSteps).reduce(Integer::sum);
                    int partialA = getPartialSteps(commandA, possibleIntersection);
                    int partialB = getPartialSteps(commandB, possibleIntersection);
                    int totalSteps = stepsA.orElse(0) + stepsB.orElse(0) + partialA + partialB;
                    intersections.put(possibleIntersection, totalSteps);
                }
            }
        }
        return intersections;
    }

    private int getPartialSteps(Command command, Point possibleIntersection) {
        switch (command.getDirection()) {
            case UP:
                return Math.abs(possibleIntersection.getY() - command.getStart().getY());
            case DOWN:
                return Math.abs(command.getEnd().getY() - possibleIntersection.getY());
            case RIGHT:
                return Math.abs(possibleIntersection.getX() - command.getStart().getX());
            case LEFT:
                return Math.abs(possibleIntersection.getX() - command.getStart().getX());
            default:
                return 0;
        }
    }

    private boolean isWithinRange(int minX, int maxX, int minY, int maxY, Point possibleIntersection) {
        return possibleIntersection.getX() >= minX
                && possibleIntersection.getX() <= maxX
                && possibleIntersection.getY() >= minY
                && possibleIntersection.getY() <= maxY;
    }

}

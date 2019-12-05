package com.martak.adventofcode.wirepathanalyzer.model;

public class Command {

    private final String direction;
    private final int steps;
    private final Point start;
    private final Point end;

    public Command(String direction, int steps, Point start, Point end) {
        this.direction = direction;
        this.steps = steps;
        this.start = start;
        this.end = end;
    }

    public String getDirection() {
        return direction;
    }

    public int getSteps() {
        return steps;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Command{" +
                "direction='" + direction + '\'' +
                ", steps=" + steps +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}

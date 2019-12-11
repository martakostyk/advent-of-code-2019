package com.martak.adventofcode.intcodecomputer.model;

public interface OpCode {

    int[] execute(int[] code, int index);

    int getShift();

    default String getOutput() {
        return "";
    }
}

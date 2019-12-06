package com.martak.adventofcode.codecomputer.model;

public interface OpCode {

    int[] execute(int[] code, int index);

    int getShift();
}

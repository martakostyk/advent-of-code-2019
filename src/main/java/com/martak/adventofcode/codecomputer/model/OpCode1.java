package com.martak.adventofcode.codecomputer.model;

public class OpCode1 implements OpCode {

    private final int shift;

    OpCode1(int shift) {
        this.shift = shift;
    }

    @Override
    public int[] execute(int[] code, int index) {
        int firstIndex = code[index + 1];
        int secondIndex = code[index + 2];
        int outputIndex = code[index + 3];
        code[outputIndex] = code[firstIndex] + code[secondIndex];
        return code;
    }

    @Override
    public int getShift() {
        return shift;
    }
}

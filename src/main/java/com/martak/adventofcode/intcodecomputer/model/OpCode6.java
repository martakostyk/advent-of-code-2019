package com.martak.adventofcode.intcodecomputer.model;

public class OpCode6 implements OpCode {

    private final int firstArgMode;
    private final int secondArgMode;
    private int shift;

    public OpCode6(int firstArgMode, int secondArgMode, int shift) {
        this.firstArgMode = firstArgMode;
        this.secondArgMode = secondArgMode;
        this.shift = shift;
    }

    @Override
    public int[] execute(int[] code, int index) {
        int first = code[index + 1];
        if (firstArgMode == 0) {
            first = code[first];
        }
        int second = code[index + 2];
        if (secondArgMode == 0) {
            second = code[second];
        }
        if (first == 0) {
            if (second > index) {
                shift = second - index;
            } else {
                shift = second - index;
            }
        }
        return code;
    }

    @Override
    public int getShift() {
        return this.shift;
    }
}

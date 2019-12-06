package com.martak.adventofcode.codecomputer.model;

public class OpCode99 implements OpCode {

    private final int shift;

    OpCode99(int shift) {
        this.shift = shift;
    }

    @Override
    public int[] execute(int[] code, int index) {
        return code;
    }

    @Override
    public int getShift() {
        return shift;
    }
}

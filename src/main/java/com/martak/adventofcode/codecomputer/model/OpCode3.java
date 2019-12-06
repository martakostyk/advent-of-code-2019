package com.martak.adventofcode.codecomputer.model;

public class OpCode3 implements OpCode {

    private final int shift;

    OpCode3(int shift) {
        this.shift = shift;
    }

    @Override
    public int[] execute(int[] code, int index) {
        int address = code[index + 1];
        // TODO implement input value to store in the given address
        code[address] = 0;
        return code;
    }

    @Override
    public int getShift() {
        return this.shift;
    }
}

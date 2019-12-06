package com.martak.adventofcode.codecomputer.model;

public class OpCode4 implements OpCode {

    private final int shift;

    OpCode4(int shift) {
        this.shift = shift;
    }

    @Override
    public int[] execute(int[] code, int index) {
        int address = code[index + 1];
        System.out.println(code[address]);
        return code;
    }

    @Override
    public int getShift() {
        return this.shift;
    }
}

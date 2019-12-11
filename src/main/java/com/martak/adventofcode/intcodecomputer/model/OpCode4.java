package com.martak.adventofcode.intcodecomputer.model;

public class OpCode4 implements OpCode {

    private final int shift;
    private String output;

    OpCode4(int shift) {
        this.shift = shift;
        this.output = "";
    }

    @Override
    public int[] execute(int[] code, int index) {
        int address = code[index + 1];
        this.output = String.valueOf(code[address]);
        return code;
    }

    @Override
    public int getShift() {
        return this.shift;
    }

    @Override
    public String getOutput() {
        return this.output;
    }
}

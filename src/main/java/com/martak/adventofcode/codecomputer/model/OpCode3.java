package com.martak.adventofcode.codecomputer.model;

public class OpCode3 implements OpCode {

    private final int shift;
    private int systemId;

    OpCode3(int shift, int systemId) {
        this.shift = shift;
        this.systemId = systemId;
    }

    @Override
    public int[] execute(int[] code, int index) {
        int address = code[index + 1];
        code[address] = systemId;
        return code;
    }

    @Override
    public int getShift() {
        return this.shift;
    }
}

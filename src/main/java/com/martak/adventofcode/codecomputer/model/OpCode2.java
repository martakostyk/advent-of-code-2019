package com.martak.adventofcode.codecomputer.model;

public class OpCode2 implements OpCode {

    private final int shift;
    private final int firstArgMode;
    private final int secondArgMode;

    OpCode2(int shift, int firstArgMode, int secondArgMode) {
        this.shift = shift;
        this.firstArgMode = firstArgMode;
        this.secondArgMode = secondArgMode;
    }

    @Override
    public int[] execute(int[] code, int index) {
        int first = code[index + 1];
        int second = code[index + 2];
        int outputindex = code[index + 3];
        if (firstArgMode == 0) {
            first = code[first];
        }
        if (secondArgMode == 0) {
            second = code[second];
        }
        code[outputindex] = first * second;
        return code;
    }

    @Override
    public int getShift() {
        return shift;
    }
}

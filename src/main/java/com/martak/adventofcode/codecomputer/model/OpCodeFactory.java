package com.martak.adventofcode.codecomputer.model;

public class OpCodeFactory {

    private static final int SHIFT = 4;

    public static OpCode getOpCode(int[] inputIntCode, int index) {
        switch (inputIntCode[index]) {
            case 1:
                return new OpCode1(SHIFT);
            case 2:
                return new OpCode2(SHIFT);
            case 99:
                return new OpCode99(inputIntCode.length - index);
            default:
                throw new IllegalArgumentException("unknown opcode: " + inputIntCode[index]);
        }
    }
}

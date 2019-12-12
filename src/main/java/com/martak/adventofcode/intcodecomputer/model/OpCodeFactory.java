package com.martak.adventofcode.intcodecomputer.model;

public class OpCodeFactory {

    private static final int SHIFT_2 = 2;
    private static final int SHIFT_4 = 4;
    private static final int SHIFT_3 = 3;

    private final int[] inputSignals;
    private int signalIndex;

    public OpCodeFactory(int[] inputSignals) {
        this.inputSignals = inputSignals;
        this.signalIndex = 0;
    }

    public OpCode getOpCode(int[] inputIntCode, int index) {
        int opCodeValues = inputIntCode[index];
        int opCode = opCodeValues % 100;
        int firstArgMode = (opCodeValues / 100) % 10;
        int secondArgMode = opCodeValues / 1000;
        switch (opCode) {
            case 1:
                return new OpCode1(SHIFT_4, firstArgMode, secondArgMode);
            case 2:
                return new OpCode2(SHIFT_4, firstArgMode, secondArgMode);
            case 3:
                if (inputSignals.length == 1) {
                    return new OpCode3(SHIFT_2, inputSignals[0]);
                }
                int signal = inputSignals[signalIndex++];
                return new OpCode3(SHIFT_2, signal);
            case 4:
                return new OpCode4(SHIFT_2);
            case 5:
                return new OpCode5(firstArgMode, secondArgMode, SHIFT_3);
            case 6:
                return new OpCode6(firstArgMode, secondArgMode, SHIFT_3);
            case 7:
                return new OpCode7(SHIFT_4, firstArgMode, secondArgMode);
            case 8:
                return new OpCode8(SHIFT_4, firstArgMode, secondArgMode);
            case 99:
                return new OpCode99(inputIntCode.length - index);
            default:
                throw new IllegalArgumentException("unknown opcode: " + inputIntCode[index]);
        }
    }
}

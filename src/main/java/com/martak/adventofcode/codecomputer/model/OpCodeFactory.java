package com.martak.adventofcode.codecomputer.model;

import java.util.Optional;

public class OpCodeFactory {

    private static final int SHIFT_2 = 2;
    private static final int SHIFT_4 = 4;

    public static Optional<OpCode> getOpCode(int[] inputIntCode, int index, int systemId) {
        int opCodeValues = inputIntCode[index];
        int opCode = opCodeValues % 100;
        int firstArgMode = (opCodeValues / 100) % 10;
        int secondArgMode = opCodeValues / 1000;
        switch (opCode) {
            case 1:
                return Optional.of(new OpCode1(SHIFT_4, firstArgMode, secondArgMode));
            case 2:
                return Optional.of(new OpCode2(SHIFT_4, firstArgMode, secondArgMode));
            case 3:
                return Optional.of(new OpCode3(SHIFT_2, systemId));
            case 4:
                return Optional.of(new OpCode4(SHIFT_2));
            case 5:
                int first1 = inputIntCode[index + 1];
                int second1 = inputIntCode[index + 2];
                if (firstArgMode == 0) {
                    first1 = inputIntCode[first1];
                }
                if (secondArgMode == 0) {
                    second1 = inputIntCode[second1];
                }
                if (first1 != 0) {
                    return getOpCode(inputIntCode, second1, systemId);
                }
                return Optional.empty();
            case 6:
                int f = inputIntCode[index + 1];
                int s = inputIntCode[index + 2];
                if (firstArgMode == 0) {
                    f = inputIntCode[f];
                }
                if (secondArgMode == 0) {
                    s = inputIntCode[s];
                }
                if (f == 0) {
                    return getOpCode(inputIntCode, s, systemId);
                }
                return Optional.empty();
            case 7:
                return Optional.of(new OpCode7(SHIFT_4, firstArgMode, secondArgMode));
            case 8:
                return Optional.of(new OpCode8(SHIFT_4, firstArgMode, secondArgMode));
            case 99:
                return Optional.of(new OpCode99(inputIntCode.length - index));
            default:
                throw new IllegalArgumentException("unknown opcode: " + inputIntCode[index]);
        }
    }
}

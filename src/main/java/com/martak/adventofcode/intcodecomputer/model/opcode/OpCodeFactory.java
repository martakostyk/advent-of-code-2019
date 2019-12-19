package com.martak.adventofcode.intcodecomputer.model.opcode;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OpCodeFactory {

    public static OpCode getOpCode(BigInteger instruction) {
        switch (instruction.intValue() % 100) {
            case 1:
                return new OpCode1();
            case 2:
                return new OpCode2();
            case 3:
                return new OpCode3();
            case 4:
                return new OpCode4();
            case 5:
                return new OpCode5();
            case 6:
                return new OpCode6();
            case 7:
                return new OpCode7();
            case 8:
                return new OpCode8();
            case 9:
                return new OpCode9();
            case 99:
                return new OpCode99();
            default:
                throw new IllegalArgumentException("unknown opcode " + instruction.intValue() % 100);
        }
    }
}

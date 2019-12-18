package com.martak.adventofcode.intcodecomputer.model.argmode;

public class PositionArgMode implements ArgMode {

    @Override
    public int getValue(int[] code, int pointer) {
        int address = code[pointer];
        return code[address];
    }
}

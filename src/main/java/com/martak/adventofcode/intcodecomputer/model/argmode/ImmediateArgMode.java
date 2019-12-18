package com.martak.adventofcode.intcodecomputer.model.argmode;

public class ImmediateArgMode implements ArgMode {

    @Override
    public int getValue(int[] code, int pointer) {
        return code[pointer];
    }
}

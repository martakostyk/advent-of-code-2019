package com.martak.adventofcode.intcodecomputer.model.argmode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class PositionArgMode implements ArgMode {

    @Override
    public int getValue(Context context, int pointer) {
        int[] code = context.getCode();
        int address = code[pointer];
        return code[address];
    }
}

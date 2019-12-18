package com.martak.adventofcode.intcodecomputer.model.argmode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class RelativeArgMode implements ArgMode {

    @Override
    public int getValue(Context context, int pointer) {
        int[] code = context.getCode();
        int relativeBase = context.getRelativeBase();
        int address = relativeBase + code[pointer];
        return code[address];
    }
}

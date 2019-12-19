package com.martak.adventofcode.intcodecomputer.model.argmode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class RelativeArgMode implements ArgMode {

    @Override
    public long getValue(Context context, int pointer) {
        long[] code = context.getCode();
        int relativeBase = context.getRelativeBase();
        int address = relativeBase + (int) code[pointer];
        return (int) code[address];
    }
}

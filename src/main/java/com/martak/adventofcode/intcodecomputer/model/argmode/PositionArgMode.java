package com.martak.adventofcode.intcodecomputer.model.argmode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class PositionArgMode implements ArgMode {

    @Override
    public long getValue(Context context, int pointer) {
        long[] code = context.getCode();
        int address = (int) code[pointer];
        return code[address];
    }
}

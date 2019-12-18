package com.martak.adventofcode.intcodecomputer.model.argmode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class ImmediateArgMode implements ArgMode {

    @Override
    public int getValue(Context context, int pointer) {
        int[] code = context.getCode();
        return code[pointer];
    }
}

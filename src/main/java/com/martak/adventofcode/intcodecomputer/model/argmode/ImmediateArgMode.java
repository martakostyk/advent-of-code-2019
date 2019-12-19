package com.martak.adventofcode.intcodecomputer.model.argmode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class ImmediateArgMode implements ArgMode {

    @Override
    public long getValue(Context context, int pointer) {
        long[] code = context.getCode();
        return code[pointer];
    }
}

package com.martak.adventofcode.intcodecomputer.model.argmode;

import com.martak.adventofcode.intcodecomputer.model.Context;

import java.math.BigInteger;

public class ImmediateArgMode implements ArgMode {

    @Override
    public BigInteger getValue(Context context, int pointer) {
        BigInteger[] code = context.getCode();
        return code[pointer];
    }
}

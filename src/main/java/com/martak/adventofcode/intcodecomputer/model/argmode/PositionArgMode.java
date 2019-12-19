package com.martak.adventofcode.intcodecomputer.model.argmode;

import com.martak.adventofcode.intcodecomputer.model.Context;

import java.math.BigInteger;

public class PositionArgMode implements ArgMode {

    @Override
    public BigInteger getValue(Context context, int pointer) {
        BigInteger[] code = context.getCode();
        int address = code[pointer].intValue();
        return code[address];
    }
}

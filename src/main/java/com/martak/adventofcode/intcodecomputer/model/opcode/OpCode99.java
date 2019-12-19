package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class OpCode99 implements OpCode {

    @Override
    public Context execute(Context context) {
        return new Context(context.getCode().length, context.getCode(), context.getInputs(),
                context.getOutput(), context.getRelativeBase());
    }
}

package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class OpCode4 implements OpCode {

    @Override
    public Context execute(Context context) {
        int[] code = context.getCode();
        int pointer = context.getPointer();
        int address = code[pointer + 1];
        String output = String.valueOf(code[address]);
        return new Context(pointer + 2, code, context.getInputs(), output, context.getRelativeBase());
    }
}

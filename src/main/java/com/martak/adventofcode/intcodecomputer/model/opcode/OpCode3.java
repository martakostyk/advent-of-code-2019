package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class OpCode3 implements OpCode {

    @Override
    public Context execute(Context context) {
        long[] code = context.getCode();
        int pointer = context.getPointer();
        int address = (int) code[pointer + 1];
        long[] inputs = context.getInputs();
        code[address] = inputs[0];
        if (inputs.length > 1) {
            inputs = new long[]{inputs[1]};
        }
        return new Context(pointer + 2, code, inputs, context.getOutput(), context.getRelativeBase());
    }
}

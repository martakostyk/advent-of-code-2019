package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;

import java.math.BigInteger;

public class OpCode3 implements OpCode {

    @Override
    public Context execute(Context context) {
        BigInteger[] code = context.getCode();
        int pointer = context.getPointer();
        int address = code[pointer + 1].intValue();
        BigInteger[] inputs = context.getInputs();
        code[address] = inputs[0];
        if (inputs.length > 1) {
            inputs = new BigInteger[]{inputs[1]};
        }
        return new Context(pointer + 2, code, inputs, context.getOutput(), context.getRelativeBase());
    }
}

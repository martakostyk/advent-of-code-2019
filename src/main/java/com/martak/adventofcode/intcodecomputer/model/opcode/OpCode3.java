package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;

import java.util.Arrays;

public class OpCode3 implements OpCode {

    @Override
    public Context execute(Context context) {
        int[] code = context.getCode();
        int pointer = context.getPointer();
        int address = code[pointer + 1];
        int[] inputs = context.getInputs();
        code[address] = inputs[0];
        if (inputs.length > 1) {
            inputs = Arrays.copyOfRange(inputs, 1, inputs.length);
        }
        return new Context(pointer + 2, code, inputs, context.getOutput());
    }
}

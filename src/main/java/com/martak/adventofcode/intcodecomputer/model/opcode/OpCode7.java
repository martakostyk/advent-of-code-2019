package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class OpCode7 implements OpCode {

    @Override
    public Context execute(Context context) {
        int[] code = context.getCode();
        int pointer = context.getPointer();
        int[] argModes = getArgModes(code[pointer]);
        int first = code[pointer + 1];
        if (argModes[0] == 0) {
            first = code[first];
        }
        int second = code[pointer + 2];
        if (argModes[1] == 0) {
            second = code[second];
        }
        int outputIndex = code[pointer + 3];
        code[outputIndex] = (first < second) ? 1 : 0;
        return new Context(pointer + 4, code, context.getInputs(), context.getOutput());
    }
}

package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class OpCode6 implements OpCode {

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
        if (first == 0) {
            pointer = second;
        } else {
            pointer += 3;
        }
        return new Context(pointer, code, context.getInputs(), context.getOutput());
    }
}

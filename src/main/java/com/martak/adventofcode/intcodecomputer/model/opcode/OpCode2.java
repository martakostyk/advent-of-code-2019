package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public class OpCode2 implements OpCode {

    @Override
    public Context execute(Context context) {
        int[] code = context.getCode();
        int pointer = context.getPointer();
        int first = code[pointer + 1];
        int second = code[pointer + 2];
        int outPutIndex = code[pointer + 3];
        int[] argModes = getArgModes(code[pointer]);
        if (argModes[0] == 0) {
            first = code[first];
        }
        if (argModes[1] == 0) {
            second = code[second];
        }
        code[outPutIndex] = first * second;
        return new Context(pointer + 4, code, context.getInputs(), context.getOutput());
    }
}

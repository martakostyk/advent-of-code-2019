package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgMode;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgModeFactory;

public class OpCode1 implements OpCode {

    @Override
    public Context execute(Context context) {
        int[] code = context.getCode();
        int pointer = context.getPointer();
        int outPutIndex = code[pointer + 3];
        ArgMode argMode1 = ArgModeFactory.getArgMode((code[pointer] / 100) % 10);
        ArgMode argMode2 = ArgModeFactory.getArgMode((code[pointer] / 1000));
        int first = argMode1.getValue(code, pointer + 1);
        int second = argMode2.getValue(code, pointer + 2);
        code[outPutIndex] = first + second;
        return new Context(pointer + 4, code, context.getInputs(), context.getOutput(), context.getRelativeBase());
    }
}


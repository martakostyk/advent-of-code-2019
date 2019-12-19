package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgMode;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgModeFactory;

public class OpCode1 implements OpCode {

    @Override
    public Context execute(Context context) {
        long[] code = context.getCode();
        int pointer = context.getPointer();
        int outputIndex = (int) code[pointer + 3];
        ArgMode argMode1 = ArgModeFactory.getArgMode(((int)(code[pointer])/ 100) % 10);
        ArgMode argMode2 = ArgModeFactory.getArgMode((int)(code[pointer]) / 1000);
        long first = argMode1.getValue(context, pointer + 1);
        long second = argMode2.getValue(context, pointer + 2);
        code[outputIndex] = first + second;
        return new Context(pointer + 4, code, context.getInputs(), context.getOutput(), context.getRelativeBase());
    }
}

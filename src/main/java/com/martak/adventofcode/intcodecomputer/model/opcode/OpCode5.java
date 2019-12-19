package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgMode;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgModeFactory;

public class OpCode5 implements OpCode {

    @Override
    public Context execute(Context context) {
        long[] code = context.getCode();
        int pointer = context.getPointer();
        ArgMode argMode1 = ArgModeFactory.getArgMode(((int)(code[pointer]) / 100) % 10);
        ArgMode argMode2 = ArgModeFactory.getArgMode((int)(code[pointer]) / 1000);
        long first = argMode1.getValue(context, pointer + 1);
        long second = argMode2.getValue(context, pointer + 2);
        if (first > 0) {
            pointer = (int) second;
        } else {
            pointer += 3;
        }
        return new Context(pointer, code, context.getInputs(), context.getOutput(), context.getRelativeBase());
    }
}

package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgMode;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgModeFactory;

public class OpCode9 implements OpCode {

    @Override
    public Context execute(Context context) {
        long[] code = context.getCode();
        int pointer = context.getPointer();
        ArgMode argMode = ArgModeFactory.getArgMode(((int)(code[pointer]) / 100) % 10);
        long value = argMode.getValue(context, pointer + 1);
        int relativeBase = context.getRelativeBase() + (int) value;
        return new Context(pointer + 2, code, context.getInputs(), context.getOutput(), relativeBase);
    }
}

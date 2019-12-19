package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgMode;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgModeFactory;

import java.math.BigInteger;

public class OpCode1 implements OpCode {

    @Override
    public Context execute(Context context) {
        BigInteger[] code = context.getCode();
        int pointer = context.getPointer();
        int outputIndex = code[pointer + 3].intValue();
        ArgMode argMode1 = ArgModeFactory.getArgMode((code[pointer].intValue() / 100) % 10);
        ArgMode argMode2 = ArgModeFactory.getArgMode(code[pointer].intValue() / 1000);
        BigInteger first = argMode1.getValue(context, pointer + 1);
        BigInteger second = argMode2.getValue(context, pointer + 2);
        code[outputIndex] = first.add(second);
        return new Context(pointer + 4, code, context.getInputs(), context.getOutput(), context.getRelativeBase());
    }
}

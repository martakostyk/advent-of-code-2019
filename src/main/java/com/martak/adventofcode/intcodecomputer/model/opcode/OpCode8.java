package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgMode;
import com.martak.adventofcode.intcodecomputer.model.argmode.ArgModeFactory;

import java.math.BigInteger;

public class OpCode8 implements OpCode {

    @Override
    public Context execute(Context context) {
        BigInteger[] code = context.getCode();
        int pointer = context.getPointer();
        ArgMode argMode1 = ArgModeFactory.getArgMode((code[pointer].intValue() / 100) % 10);
        ArgMode argMode2 = ArgModeFactory.getArgMode(code[pointer].intValue() / 1000);
        BigInteger first = argMode1.getValue(context, pointer + 1);
        BigInteger second = argMode2.getValue(context, pointer + 2);
        int outputIndex = code[pointer + 3].intValue();
        code[outputIndex] = (first.compareTo(second) == 0) ? BigInteger.valueOf(1) : BigInteger.valueOf(0);
        return new Context(pointer + 4, code, context.getInputs(), context.getOutput(), context.getRelativeBase());
    }
}

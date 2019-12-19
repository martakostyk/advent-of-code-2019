package com.martak.adventofcode.intcodecomputer;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.opcode.OpCode;
import com.martak.adventofcode.intcodecomputer.model.opcode.OpCodeFactory;

public class CodeComputer {

    public Context execute(Context context) {
        String currentOutput = context.getOutput();
        while (context.getOutput().equals(currentOutput) && context.getPointer() < context.getCode().length) {
            OpCode opCode = OpCodeFactory.getOpCode((int) context.getCode()[context.getPointer()]);
            context = opCode.execute(context);
        }
        return context;
    }
}

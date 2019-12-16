package com.martak.adventofcode.intcodecomputer;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.opcode.OpCode;
import com.martak.adventofcode.intcodecomputer.model.opcode.OpCodeFactory;
import com.martak.adventofcode.utils.InputStorage;

public class CodeComputer {

    public static void main(String[] args) {
        int[] diagnosticTests = InputStorage.getDiagnosticTests();
        Context context = new Context(0, diagnosticTests, new int[]{Integer.parseInt(args[0])}, "");
        while (context.getPointer() < context.getCode().length) {
            context = new CodeComputer().execute(context);
        }
        System.out.println("Code computer output " + context.getOutput());
    }

    public Context execute(Context context) {
        String currentOutput = context.getOutput();
        while (context.getOutput().equals(currentOutput) && context.getPointer() < context.getCode().length) {
            OpCode opCode = OpCodeFactory.getOpCode(context.getCode()[context.getPointer()]);
            context = opCode.execute(context);
        }
        return context;
    }
}

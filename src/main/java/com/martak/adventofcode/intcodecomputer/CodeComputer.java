package com.martak.adventofcode.intcodecomputer;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.intcodecomputer.model.opcode.OpCode;
import com.martak.adventofcode.intcodecomputer.model.opcode.OpCodeFactory;
import com.martak.adventofcode.utils.InputStorage;

public class CodeComputer {

    public static void main(String[] args) {
        int[] diagnosticTests = InputStorage.getDiagnosticTests();
        String output = new CodeComputer()
                .execute(diagnosticTests, new int[]{Integer.parseInt(args[0])});
        System.out.println("Code computer output " + output);
    }

    private int findPair() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[] code = InputStorage.getInput();
                code[1] = i;
                code[2] = j;
                execute(code, new int[]{0});
                if (code[0] == 19690720) {
                    return 100 * i + j;
                }
            }
        }
        return 0;
    }

    public String execute(int[] code, int[] inputs) {
        StringBuilder output = new StringBuilder();
        Context context = new Context(0, code, inputs, output.toString());
        while (context.getPointer() < context.getCode().length) {
            OpCode opCode = OpCodeFactory.getOpCode(context.getCode()[context.getPointer()]);
            context = opCode.execute(context);
            output.append(context.getOutput());
        }
        return context.getOutput();
    }
}

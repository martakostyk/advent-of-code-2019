package com.martak.adventofcode.intcodecomputer;

import com.martak.adventofcode.intcodecomputer.model.OpCode;
import com.martak.adventofcode.intcodecomputer.model.OpCodeFactory;
import com.martak.adventofcode.utils.InputStorage;

public class CodeComputer {

    public static void main(String[] args) {
        int systemId = Integer.parseInt(args[0]);
        int[] diagnosticTests = InputStorage.getDiagnosticTests();
        String output = new CodeComputer().execute(diagnosticTests, new int[] {systemId});
        System.out.println("Code computer output " + output);
    }

    private int findPair() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[] code = InputStorage.getInput();
                code[1] = i;
                code[2] = j;
                execute(code, new int[] {0});
                if (code[0] == 19690720) {
                    return 100 * i + j;
                }
            }
        }
        return 0;
    }

    private String execute(int[] code, int[] inputSignals) {
        int index = 0;
        StringBuilder output = new StringBuilder();
        OpCodeFactory opCodeFactory = new OpCodeFactory(inputSignals);
        while (index < code.length) {
            OpCode opCode = opCodeFactory.getOpCode(code, index);
            code = opCode.execute(code, index);
            index += opCode.getShift();
            output.append(opCode.getOutput());
        }
        return output.toString();
    }
}

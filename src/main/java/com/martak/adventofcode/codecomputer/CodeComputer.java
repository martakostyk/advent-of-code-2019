package com.martak.adventofcode.codecomputer;

import com.martak.adventofcode.codecomputer.model.OpCode;
import com.martak.adventofcode.codecomputer.model.OpCodeFactory;

public class CodeComputer {

    public static void main(String[] args) {
        int systemId = Integer.parseInt(args[0]);
        int[] diagnosticTests = getDiagnosticTests();
        new CodeComputer().execute(diagnosticTests, systemId);
    }

    private int findPair() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[] code = getInput();
                code[1] = i;
                code[2] = j;
                execute(code, 0);
                if (code[0] == 19690720) {
                    return getAnswer(i, j);
                }
            }
        }
        return 0;
    }

    private int getAnswer(int noun, int verb) {
        return 100 * noun + verb;
    }

    private static int[] getInput() {
        return new int[]{
                1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 6, 1, 19, 1, 19, 5, 23, 2, 10, 23, 27,
                2, 27, 13, 31, 1, 10, 31, 35, 1, 35, 9, 39, 2, 39, 13, 43, 1, 43, 5, 47, 1, 47, 6, 51,
                2, 6, 51, 55, 1, 5, 55, 59, 2, 9, 59, 63, 2, 6, 63, 67, 1, 13, 67, 71, 1, 9, 71, 75,
                2, 13, 75, 79, 1, 79, 10, 83, 2, 83, 9, 87, 1, 5, 87, 91, 2, 91, 6, 95, 2, 13, 95, 99,
                1, 99, 5, 103, 1, 103, 2, 107, 1, 107, 10, 0, 99, 2, 0, 14, 0};
    }

    private static int[] getDiagnosticTests() {
        return new int[]{3, 225, 1, 225, 6, 6, 1100, 1, 238, 225, 104, 0, 1102, 89, 49, 225, 1102, 35, 88, 224, 101,
                -3080, 224, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 3, 224, 1, 223, 224, 223, 1101, 25, 33, 224, 1001, 224, -58, 224, 4, 224, 102, 8, 223, 223, 101, 5, 224, 224, 1, 223, 224, 223, 1102, 78, 23, 225, 1, 165, 169, 224, 101, -80, 224, 224, 4, 224, 102, 8, 223, 223, 101, 7, 224, 224, 1, 224, 223, 223, 101, 55, 173, 224, 1001, 224, -65, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 1, 224, 1, 223, 224, 223, 2, 161, 14, 224, 101, -3528, 224, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 7, 224, 1, 224, 223, 223, 1002, 61, 54, 224, 1001, 224, -4212, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 1, 224, 1, 223, 224, 223, 1101, 14, 71, 225, 1101, 85, 17, 225, 1102, 72, 50, 225, 1102, 9, 69, 225, 1102, 71, 53, 225, 1101, 10, 27, 225, 1001, 158, 34, 224, 101, -51, 224, 224, 4, 224, 102, 8, 223, 223, 101, 6, 224, 224, 1, 223, 224, 223, 102, 9, 154, 224, 101, -639, 224, 224, 4, 224, 102, 8, 223, 223, 101, 2, 224, 224, 1, 224, 223, 223, 4, 223, 99, 0, 0, 0, 677, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1105, 0, 99999, 1105, 227, 247, 1105, 1, 99999, 1005, 227, 99999, 1005, 0, 256, 1105, 1, 99999, 1106, 227, 99999, 1106, 0, 265, 1105, 1, 99999, 1006, 0, 99999, 1006, 227, 274, 1105, 1, 99999, 1105, 1, 280, 1105, 1, 99999, 1, 225, 225, 225, 1101, 294, 0, 0, 105, 1, 0, 1105, 1, 99999, 1106, 0, 300, 1105, 1, 99999, 1, 225, 225, 225, 1101, 314, 0, 0, 106, 0, 0, 1105, 1, 99999, 108, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 329, 101, 1, 223, 223, 1007, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 344, 1001, 223, 1, 223, 8, 226, 677, 224, 1002, 223, 2, 223, 1006, 224, 359, 1001, 223, 1, 223, 108, 226, 677, 224, 1002, 223, 2, 223, 1005, 224, 374, 1001, 223, 1, 223, 107, 226, 677, 224, 102, 2, 223, 223, 1006, 224, 389, 101, 1, 223, 223, 1107, 226, 226, 224, 1002, 223, 2, 223, 1005, 224, 404, 1001, 223, 1, 223, 1107, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 419, 101, 1, 223, 223, 1007, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 434, 1001, 223, 1, 223, 1108, 677, 226, 224, 1002, 223, 2, 223, 1005, 224, 449, 101, 1, 223, 223, 1008, 226, 226, 224, 102, 2, 223, 223, 1005, 224, 464, 101, 1, 223, 223, 7, 226, 677, 224, 102, 2, 223, 223, 1006, 224, 479, 101, 1, 223, 223, 1008, 226, 677, 224, 1002, 223, 2, 223, 1006, 224, 494, 101, 1, 223, 223, 1107, 226, 677, 224, 1002, 223, 2, 223, 1005, 224, 509, 1001, 223, 1, 223, 1108, 226, 226, 224, 1002, 223, 2, 223, 1006, 224, 524, 101, 1, 223, 223, 7, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 539, 1001, 223, 1, 223, 107, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 554, 101, 1, 223, 223, 107, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 569, 101, 1, 223, 223, 1008, 677, 677, 224, 1002, 223, 2, 223, 1006, 224, 584, 1001, 223, 1, 223, 8, 677, 226, 224, 1002, 223, 2, 223, 1005, 224, 599, 101, 1, 223, 223, 1108, 226, 677, 224, 1002, 223, 2, 223, 1005, 224, 614, 101, 1, 223, 223, 108, 677, 677, 224, 102, 2, 223, 223, 1005, 224, 629, 1001, 223, 1, 223, 8, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 644, 1001, 223, 1, 223, 7, 677, 226, 224, 102, 2, 223, 223, 1006, 224, 659, 1001, 223, 1, 223, 1007, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 674, 101, 1, 223, 223, 4, 223, 99, 226};
    }

    private int[] execute(int[] code, int systemId) {
        int index = 0;
        while (index < code.length) {
            OpCode opCode = OpCodeFactory.getOpCode(code, index, systemId);
            code = opCode.execute(code, index);
            index += opCode.getShift();
        }
        return code;
    }
}

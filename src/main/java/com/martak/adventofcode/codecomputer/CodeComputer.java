package com.martak.adventofcode.codecomputer;

public class CodeComputer {

    public static void main(String[] args) {
        int[] inputIntCode = getInput();
        inputIntCode[1] = 12;
        inputIntCode[2] = 2;
        System.out.println(new CodeComputer().execute(inputIntCode)[0]);
        System.out.println(new CodeComputer().findPair());
    }

    private int findPair() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int[] inputIntCode = getInput();
                inputIntCode[1] = i;
                inputIntCode[2] = j;
                execute(inputIntCode);
                if (inputIntCode[0] == 19690720) {
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

    private int[] execute(int[] inputIntCode) {
        for (int i = 0; i < inputIntCode.length - 3; i = i + 4) {
            int opCode = inputIntCode[i];
            if (opCode == 99) {
                return inputIntCode;
            }
            int firstIndex = inputIntCode[i + 1];
            int secondIndex = inputIntCode[i + 2];
            int outputIndex = inputIntCode[i + 3];
            switch (opCode) {
                case 1:
                    inputIntCode[outputIndex] = inputIntCode[firstIndex] + inputIntCode[secondIndex];
                    break;
                case 2:
                    inputIntCode[inputIntCode[i + 3]] = inputIntCode[firstIndex] * inputIntCode[secondIndex];
                    break;
                default:
                    throw new IllegalArgumentException("unknown opcode " + opCode + ", index " + i);
            }
        }
        return inputIntCode;
    }
}

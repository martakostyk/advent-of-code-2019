package com.martak.adventofcode.amplificationcircuit;

public class PhaseSequenceGenerator {

    public static int[][] getAllCombinations(int min, int max) {
        int numOfPhases = max - min + 1;
        int numOfCombinations = getNumOfCombinations(numOfPhases);
        int[][] phaseSequences = new int[numOfCombinations][numOfPhases];
        int phaseSequenceIndex = 0;
        for (int i = min; i <= max; i++) {
            for (int j = min; j <= max; j++) {
                if (j != i) {
                    for (int k = min; k <= max; k++) {
                        if (k != i && k != j) {
                            for (int l = min; l <= max; l++) {
                                if (l != i && l != j && l != k) {
                                    for (int m = min; m <= max; m++) {
                                        if (m != i && m != j && m != k && m != l) {
                                            phaseSequences[phaseSequenceIndex][i] = 0;
                                            phaseSequences[phaseSequenceIndex][j] = 1;
                                            phaseSequences[phaseSequenceIndex][k] = 2;
                                            phaseSequences[phaseSequenceIndex][l] = 3;
                                            phaseSequences[phaseSequenceIndex][m] = 4;
                                            phaseSequenceIndex++;
                                        }

                                    }
                                }

                            }
                        }

                    }
                }
            }
        }
        return phaseSequences;
    }

    private static int getNumOfCombinations(int numberOfPhases) {
        int numOfCombinations = 1;
        while (numberOfPhases > 0) {
            numOfCombinations *= numberOfPhases--;
        }
        return numOfCombinations;
    }
}

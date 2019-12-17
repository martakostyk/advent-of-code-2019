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
                                            phaseSequences[phaseSequenceIndex][0] = i;
                                            phaseSequences[phaseSequenceIndex][1] = j;
                                            phaseSequences[phaseSequenceIndex][2] = k;
                                            phaseSequences[phaseSequenceIndex][3] = l;
                                            phaseSequences[phaseSequenceIndex][4] = m;
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

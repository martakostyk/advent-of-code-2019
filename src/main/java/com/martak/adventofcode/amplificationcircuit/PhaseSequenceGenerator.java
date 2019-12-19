package com.martak.adventofcode.amplificationcircuit;

import java.math.BigInteger;

public class PhaseSequenceGenerator {

    public static BigInteger[][] getAllCombinations(int min, int max) {
        int numOfPhases = max - min + 1;
        int numOfCombinations = getNumOfCombinations(numOfPhases);
        BigInteger[][] phaseSequences = new BigInteger[numOfCombinations][numOfPhases];
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
                                            phaseSequences[phaseSequenceIndex][0] = BigInteger.valueOf(i);
                                            phaseSequences[phaseSequenceIndex][1] = BigInteger.valueOf(j);
                                            phaseSequences[phaseSequenceIndex][2] = BigInteger.valueOf(k);
                                            phaseSequences[phaseSequenceIndex][3] = BigInteger.valueOf(l);
                                            phaseSequences[phaseSequenceIndex][4] = BigInteger.valueOf(m);
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

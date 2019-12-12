package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.utils.InputStorage;

import java.util.ArrayList;
import java.util.List;

public class AmplifierSystem {

    private final List<Amplifier> amplifiers;

    public AmplifierSystem(List<Amplifier> amplifiers) {
        this.amplifiers = amplifiers;
    }

    public static void main(String[] args) {
        List<String> phaseSequenceCombinations = AmplifierSystem.getAllPhaseSequenceCombinations();
        int[] controllerSoftware = InputStorage.getControllerSoftware();
        String theBiggestThrusterSignal = "";
        for (String phaseSequence : phaseSequenceCombinations) {
            List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence);
            AmplifierSystem amplifierSystem = new AmplifierSystem(amplifiers);
            String thrusterSignal = amplifierSystem.execute(controllerSoftware);
            if (thrusterSignal.compareTo(theBiggestThrusterSignal) > 0) {
                theBiggestThrusterSignal = thrusterSignal;
            }
        }
        System.out.println("The biggest thruster signal " + theBiggestThrusterSignal);
    }

    public String execute(int[] controllerSoftware) {
        int output = 0;
        for (int i = 0; i < 5; i++) {
            Amplifier amplifier = amplifiers.get(i);
            int[] inputSignals = new int[]{amplifier.getPhase(), output};
            output = Integer.valueOf(amplifier.execute(controllerSoftware, inputSignals));
        }
        return String.valueOf(output);
    }

    private static List<String> getAllPhaseSequenceCombinations() {
        List<String> phaseSequenceCombinations = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 5; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    for (int l = 0; l < 5; l++) {
                        if (i == l || j == l || k == l) {
                            continue;
                        }
                        for (int m = 0; m < 5; m++) {
                            if (i == m || j == m || k == m || l == m) {
                                continue;
                            }
                            phaseSequenceCombinations.add(i + "" + j + "" + k + "" + l + "" + m);
                        }
                    }
                }
            }
        }
        return phaseSequenceCombinations;
    }


}

package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.utils.InputStorage;

import java.util.List;

public class AmplifierSystem {

    public static void main(String[] args) {
        int[] controllerSoftware = InputStorage.getControllerSoftware();
        int[][] phaseSequences = PhaseSequenceGenerator.getAllCombinations(0, 4);

        String theBiggest = findTheBiggestOutputSignal(phaseSequences, controllerSoftware);
        System.out.println("The biggest output signal " + theBiggest);
    }

    public static String findTheBiggestOutputSignal(int[][] phaseSequences, int[] controllerSoftware) {
        String theBiggestThrusterSignal = "";
        for (int[] phaseSequence : phaseSequences) {
            List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence);
            String thrusterSignal = AmplifierSystem.execute(amplifiers, controllerSoftware);
            if (thrusterSignal.compareTo(theBiggestThrusterSignal) > 0) {
                theBiggestThrusterSignal = thrusterSignal;
            }
        }
        return theBiggestThrusterSignal;
    }

    public static String execute(List<Amplifier> amplifiers, int[] controllerSoftware) {
        int output = 0;
        for (int i = 0; i < 5; i++) {
            Amplifier amplifier = amplifiers.get(i);
            output = Integer.valueOf(amplifier.execute(controllerSoftware, output));
        }
        return String.valueOf(output);
    }

}

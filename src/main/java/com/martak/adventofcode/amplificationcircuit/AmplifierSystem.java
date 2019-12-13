package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.utils.InputStorage;

import java.util.List;

public class AmplifierSystem {

    private final List<Amplifier> amplifiers;

    public AmplifierSystem(List<Amplifier> amplifiers) {
        this.amplifiers = amplifiers;
    }

    public static void main(String[] args) {
        int[][] phaseSequenceCombinations = PhaseSequenceGenerator.getAllSequenceCombinations(0, 4);
        int[] controllerSoftware = InputStorage.getControllerSoftware();
        String theBiggestThrusterSignal = "";
        for (int[] phaseSequence : phaseSequenceCombinations) {
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

}

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
            List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence, controllerSoftware);
            String thrusterSignal = AmplifierSystem.execute(amplifiers);
            if (thrusterSignal.compareTo(theBiggestThrusterSignal) > 0) {
                theBiggestThrusterSignal = thrusterSignal;
            }
        }
        return theBiggestThrusterSignal;
    }

    public static String execute(List<Amplifier> amplifiers) {
        boolean isFinalLoopProcessed = false;
        while (!isFinalLoopProcessed) {
            int output = 0;
            for (int i = 0; i < 5; i++) {
                Amplifier amplifier = amplifiers.get(i);
                int[] inputs = amplifier.getContext().getInputs();
                if (inputs.length > 1) {
                    inputs[1] = output;
                } else {
                    inputs[0] = output;
                }
                amplifier.getContext().setInputs(inputs);
                amplifier.execute();
                output = Integer.valueOf(amplifier.getContext().getOutput());
                if (i == amplifiers.size() - 1 && amplifier.getContext().getPointer() == amplifier.getContext().getCode().length) {
                    isFinalLoopProcessed = !isFinalLoopProcessed;
                }
            }
        }
        return amplifiers.get(4).getContext().getOutput();
    }
}

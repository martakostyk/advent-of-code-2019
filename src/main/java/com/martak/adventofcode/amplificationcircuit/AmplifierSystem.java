package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.utils.ProgramInitializer;

import java.util.List;

public class AmplifierSystem {

    public static void main(String[] args) {
        long[] controllerSoftware = ProgramInitializer.getControllerSoftware();

        long[][] phaseSequences1 = PhaseSequenceGenerator.getAllCombinations(0, 4);
        String theBiggest1 = findTheBiggestOutputSignal(phaseSequences1, controllerSoftware);
        System.out.println("The biggest output signal (simple mode) " + theBiggest1);

        long[][] phaseSequences2 = PhaseSequenceGenerator.getAllCombinations(5, 9);
        String theBiggest2 = findTheBiggestOutputSignal(phaseSequences2, controllerSoftware);
        System.out.println("The biggest output signal (loop mode) " + theBiggest2);
    }

    public static String findTheBiggestOutputSignal(long[][] phaseSequences, long[] controllerSoftware) {
        long theBiggestThrusterSignal = 0;
        for (long[] phaseSequence : phaseSequences) {
            List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence, controllerSoftware);
            long thrusterSignal = AmplifierSystem.execute(amplifiers);
            if (thrusterSignal > theBiggestThrusterSignal) {
                theBiggestThrusterSignal = thrusterSignal;
            }
        }
        return String.valueOf(theBiggestThrusterSignal);
    }

    public static long execute(List<Amplifier> amplifiers) {
        boolean isFinalLoopProcessed = false;
        long output = 0;
        while (!isFinalLoopProcessed) {
            for (int i = 0; i < 5; i++) {
                Amplifier amplifier = amplifiers.get(i);
                long[] inputs = amplifier.getContext().getInputs();
                if (inputs.length > 1) {
                    inputs[1] = output;
                } else {
                    inputs[0] = output;
                }
                amplifier.getContext().setInputs(inputs);
                amplifier.execute();
                output = Long.valueOf(amplifier.getContext().getOutput());
                if (i == amplifiers.size() - 1 && amplifier.getContext().getPointer() == amplifier.getContext().getCode().length) {
                    isFinalLoopProcessed = !isFinalLoopProcessed;
                }
            }
        }
        return output;
    }
}

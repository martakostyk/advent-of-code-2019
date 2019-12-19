package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.utils.ProgramInitializer;

import java.math.BigInteger;
import java.util.List;

public class AmplifierSystem {

    public static void main(String[] args) {
        BigInteger[] controllerSoftware = ProgramInitializer.getControllerSoftware();

        BigInteger[][] phaseSequences1 = PhaseSequenceGenerator.getAllCombinations(0, 4);
        String theBiggest1 = findTheBiggestOutputSignal(phaseSequences1, controllerSoftware);
        System.out.println("The biggest output signal (simple mode) " + theBiggest1);

        BigInteger[][] phaseSequences2 = PhaseSequenceGenerator.getAllCombinations(5, 9);
        String theBiggest2 = findTheBiggestOutputSignal(phaseSequences2, controllerSoftware);
        System.out.println("The biggest output signal (loop mode) " + theBiggest2);
    }

    public static String findTheBiggestOutputSignal(BigInteger[][] phaseSequences, BigInteger[] controllerSoftware) {
        BigInteger theBiggestThrusterSignal = BigInteger.valueOf(0);
        for (BigInteger[] phaseSequence : phaseSequences) {
            List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence, controllerSoftware);
            BigInteger thrusterSignal = AmplifierSystem.execute(amplifiers);
            if (thrusterSignal.compareTo(theBiggestThrusterSignal) > 0) {
                theBiggestThrusterSignal = thrusterSignal;
            }
        }
        return String.valueOf(theBiggestThrusterSignal);
    }

    public static BigInteger execute(List<Amplifier> amplifiers) {
        boolean isFinalLoopProcessed = false;
        BigInteger output = BigInteger.valueOf(0);
        while (!isFinalLoopProcessed) {
            for (int i = 0; i < 5; i++) {
                Amplifier amplifier = amplifiers.get(i);
                BigInteger[] inputs = amplifier.getContext().getInputs();
                if (inputs.length > 1) {
                    inputs[1] = output;
                } else {
                    inputs[0] = output;
                }
                amplifier.getContext().setInputs(inputs);
                amplifier.execute();
                output = new BigInteger(amplifier.getContext().getOutput());
                if (i == amplifiers.size() - 1 && amplifier.getContext().getPointer() == amplifier.getContext().getCode().length) {
                    isFinalLoopProcessed = !isFinalLoopProcessed;
                }
            }
        }
        return output;
    }
}

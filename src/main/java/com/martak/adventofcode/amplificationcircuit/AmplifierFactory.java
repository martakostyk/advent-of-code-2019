package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.intcodecomputer.CodeComputer;

import java.util.ArrayList;
import java.util.List;

public class AmplifierFactory {

    public static List<Amplifier> getAmplifiers(int[] phaseSequence) {
        List<Amplifier> amplifiers = new ArrayList<>(phaseSequence.length);
        for (int i = 0; i < 5; i++) {
            amplifiers.add(new Amplifier(phaseSequence[i], new CodeComputer()));
        }
        return amplifiers;
    }
}

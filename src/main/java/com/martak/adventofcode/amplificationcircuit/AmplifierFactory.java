package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.intcodecomputer.CodeComputer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmplifierFactory {

    public static List<Amplifier> getAmplifiers(String phaseSettingSequence) {
        List<Amplifier> amplifiers = new ArrayList<>(5);
        Integer sequence = Integer.valueOf(phaseSettingSequence);
        for (int i = 0; i < 5; i++) {
            amplifiers.add(new Amplifier(sequence % 10, new CodeComputer()));
            sequence /= 10;
        }
        Collections.reverse(amplifiers);
        return amplifiers;
    }
}

package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.intcodecomputer.CodeComputer;
import com.martak.adventofcode.intcodecomputer.model.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmplifierFactory {

    public static List<Amplifier> getAmplifiers(long[] phaseSequence, long[] controllerSoftware) {
        List<Amplifier> amplifiers = new ArrayList<>(phaseSequence.length);
        for (int i = 0; i < 5; i++) {
            long[] inputs = {phaseSequence[i], 0};
            Context context = new Context(0, Arrays.copyOf(controllerSoftware, controllerSoftware.length), inputs, "", 0);
            amplifiers.add(new Amplifier(new CodeComputer(), context));
        }
        return amplifiers;
    }
}

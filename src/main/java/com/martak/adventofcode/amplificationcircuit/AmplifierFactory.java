package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.intcodecomputer.CodeComputer;
import com.martak.adventofcode.intcodecomputer.model.Context;

import java.util.ArrayList;
import java.util.List;

public class AmplifierFactory {

    public static List<Amplifier> getAmplifiers(int[] phaseSequence, int[] controllerSoftware) {
        List<Amplifier> amplifiers = new ArrayList<>(phaseSequence.length);
        for (int i = 0; i < 5; i++) {
            int[] inputs = {phaseSequence[i], 0};
            Context context = new Context(0, controllerSoftware, inputs, "");
            amplifiers.add(new Amplifier(new CodeComputer(), context));
        }
        return amplifiers;
    }
}

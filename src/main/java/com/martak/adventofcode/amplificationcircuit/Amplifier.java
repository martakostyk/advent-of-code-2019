package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.intcodecomputer.CodeComputer;

public class Amplifier {

    private int phase;
    private CodeComputer codeComputer;

    public Amplifier(int phase, CodeComputer codeComputer) {
        this.phase = phase;
        this.codeComputer = codeComputer;
    }

    public int getPhase() {
        return phase;
    }

    public String execute(int[] code, int[] inputSignals) {
        return codeComputer.execute(code, inputSignals);
    }
}

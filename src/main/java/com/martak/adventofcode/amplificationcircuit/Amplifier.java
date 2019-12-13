package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.intcodecomputer.CodeComputer;

public class Amplifier {

    private int phase;
    private CodeComputer codeComputer;

    Amplifier(int phase, CodeComputer codeComputer) {
        this.phase = phase;
        this.codeComputer = codeComputer;
    }

    public String execute(int[] code, int input) {
        return codeComputer.execute(code, new int[] {this.phase, input});
    }
}

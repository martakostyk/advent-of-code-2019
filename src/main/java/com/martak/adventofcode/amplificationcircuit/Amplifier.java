package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.intcodecomputer.CodeComputer;
import com.martak.adventofcode.intcodecomputer.model.Context;

public class Amplifier {

    private final CodeComputer codeComputer;
    private Context context;

    Amplifier(CodeComputer codeComputer, Context context) {
        this.codeComputer = codeComputer;
        this.context = context;
    }

    public void execute() {
        context = codeComputer.execute(context);
    }

    public Context getContext() {
        return this.context;
    }
}

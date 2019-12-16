package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;

public interface OpCode {

    Context execute(Context context);

    default int[] getArgModes(int instruction) {
        int firstArgMode = (instruction / 100) % 10;
        int secondArgMode = instruction / 1000;
        return new int[]{firstArgMode, secondArgMode};
    }
}

package com.martak.adventofcode.intcodecomputer.model.argmode;

public class ArgModeFactory {

    public static ArgMode getArgMode(int mode) {
        switch (mode) {
            case 0:
                return new PositionArgMode();
            case 1:
                return new ImmediateArgMode();
            case 2:
                return new RelativeArgMode();
            default:
                throw new IllegalArgumentException("unknown argument mode");
        }
    }
}

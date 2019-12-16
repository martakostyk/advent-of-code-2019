package com.martak.adventofcode.intcodecomputer.model;

public class Context {
    private final int pointer;
    private final int[] code;
    private final int[] inputs;
    private String output;

    public Context(int pointer, int[] code, int[] inputs, String output) {
        this.pointer = pointer;
        this.code = code;
        this.inputs = inputs;
        this.output = output;
    }

    public int getPointer() {
        return pointer;
    }

    public int[] getCode() {
        return code;
    }

    public int[] getInputs() {
        return inputs;
    }

    public String getOutput() {
        return output;
    }
}

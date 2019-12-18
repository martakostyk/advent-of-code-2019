package com.martak.adventofcode.intcodecomputer.model;

public class Context {
    private final int pointer;
    private final int[] code;
    private long[] inputs;
    private String output;
    private final int relativeBase;

    public Context(int pointer, int[] code, long[] inputs, String output, int relativeBase) {
        this.pointer = pointer;
        this.code = code;
        this.inputs = inputs;
        this.output = output;
        this.relativeBase = relativeBase;
    }

    public int getPointer() {
        return pointer;
    }

    public int[] getCode() {
        return code;
    }

    public long[] getInputs() {
        return inputs;
    }

    public void setInputs(long[] inputs) {
        this.inputs = inputs;
    }

    public String getOutput() {
        return output;
    }

    public int getRelativeBase() {
        return relativeBase;
    }
}

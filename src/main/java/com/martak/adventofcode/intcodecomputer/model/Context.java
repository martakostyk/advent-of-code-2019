package com.martak.adventofcode.intcodecomputer.model;

import java.util.Arrays;

public class Context {
    private final int pointer;
    private final int[] code;
    private long[] inputs;
    private String output;

    public Context(int pointer, int[] code, long[] inputs, String output) {
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

    public long[] getInputs() {
        return inputs;
    }

    public void setInputs(long[] inputs) {
        this.inputs = inputs;
    }

    public String getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return "Context{p: " + pointer + ", output:" + output
                    + ", inputs:" + Arrays.toString(inputs) + ", code:" + Arrays.toString(code) + "}";
    }
}

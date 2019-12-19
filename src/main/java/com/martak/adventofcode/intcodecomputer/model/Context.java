package com.martak.adventofcode.intcodecomputer.model;

import java.math.BigInteger;

public class Context {
    private final int pointer;
    private final BigInteger[] code;
    private BigInteger[] inputs;
    private String output;
    private final int relativeBase;

    public Context(int pointer, BigInteger[] code, BigInteger[] inputs, String output, int relativeBase) {
        this.pointer = pointer;
        this.code = code;
        this.inputs = inputs;
        this.output = output;
        this.relativeBase = relativeBase;
    }

    public int getPointer() {
        return pointer;
    }

    public BigInteger[] getCode() {
        return code;
    }

    public BigInteger[] getInputs() {
        return inputs;
    }

    public void setInputs(BigInteger[] inputs) {
        this.inputs = inputs;
    }

    public String getOutput() {
        return output;
    }

    public int getRelativeBase() {
        return relativeBase;
    }
}

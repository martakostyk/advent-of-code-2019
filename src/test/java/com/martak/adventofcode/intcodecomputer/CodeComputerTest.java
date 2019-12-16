package com.martak.adventofcode.intcodecomputer;

import com.martak.adventofcode.intcodecomputer.model.Context;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CodeComputerTest {

    @Test
    public void test1a() {
        int[] diagnosticTests = new int[]{3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9};
        Context context = new Context(0, diagnosticTests, new int[]{0}, "");
        context = new CodeComputer().execute(context);
        Assert.assertEquals(Integer.valueOf(context.getOutput()), Integer.valueOf(0));
    }

    @Test
    public void test1b() {
        int[] diagnosticTests = new int[]{3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9};
        Context context = new Context(0, diagnosticTests, new int[]{1}, "");
        context = new CodeComputer().execute(context);
        Assert.assertEquals(Integer.valueOf(context.getOutput()), Integer.valueOf(1));
    }

    @Test
    public void test2a() {
        int[] diagnosticTests = new int[]{3,3,1105,-1,9,1101,0,0,12,4,12,99,1};
        Context context = new Context(0, diagnosticTests, new int[]{0}, "");
        context = new CodeComputer().execute(context);
        Assert.assertEquals(Integer.valueOf(context.getOutput()), Integer.valueOf(0));
    }

    @Test
    public void test2b() {
        int[] diagnosticTests = new int[]{3,3,1105,-1,9,1101,0,0,12,4,12,99,1};
        Context context = new Context(0, diagnosticTests, new int[]{1}, "");
        context = new CodeComputer().execute(context);
        Assert.assertEquals(Integer.valueOf(context.getOutput()), Integer.valueOf(1));
    }
}
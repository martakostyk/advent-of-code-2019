package com.martak.adventofcode.intcodecomputer;

import com.martak.adventofcode.intcodecomputer.model.Context;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CodeComputerTest {

    private static final int POINTER = 0;
    private static final String OUTPUT = "";
    private static final int RELATIVE_BASE = 0;

    @DataProvider(name = "diagnosticTests")
    public static Object[][] diagnosticTests() {
        return new Object[][] {
                {new int[]{3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9}},
                {new int[]{3,3,1105,-1,9,1101,0,0,12,4,12,99,1}}
        };
    }

    @Test(dataProvider = "diagnosticTests")
    public void shouldOutput0WhenInputIs0(int[] diagnosticTests) {
        Context context = new Context(POINTER, diagnosticTests, new long[]{0}, OUTPUT, RELATIVE_BASE);
        context = new CodeComputer().execute(context);
        Assert.assertEquals(Integer.valueOf(context.getOutput()), Integer.valueOf(0));
    }

    @Test(dataProvider = "diagnosticTests")
    public void shouldOutput1WhenInputIs1(int[] diagnosticTests) {
        Context context = new Context(POINTER, diagnosticTests, new long[]{1}, OUTPUT, RELATIVE_BASE);
        context = new CodeComputer().execute(context);
        Assert.assertEquals(Integer.valueOf(context.getOutput()), Integer.valueOf(1));
    }
}
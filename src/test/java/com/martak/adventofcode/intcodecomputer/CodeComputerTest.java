package com.martak.adventofcode.intcodecomputer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CodeComputerTest {

    @Test
    public void test1a() {
        int input = 0;
        int[] diagnosticTests = new int[]{3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9};
        String output = new CodeComputer().execute(diagnosticTests, new int[] {input});
        Assert.assertEquals(Integer.valueOf(output), Integer.valueOf(0));
    }

    @Test
    public void test1b() {
        int input = 1;
        int[] diagnosticTests = new int[]{3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9};
        String output = new CodeComputer().execute(diagnosticTests, new int[] {input});
        Assert.assertEquals(Integer.valueOf(output), Integer.valueOf(1));
    }

    @Test
    public void test2a() {
        int input = 0;
        int[] diagnosticTests = new int[]{3,3,1105,-1,9,1101,0,0,12,4,12,99,1};
        String output = new CodeComputer().execute(diagnosticTests, new int[] {input});
        Assert.assertEquals(Integer.valueOf(output), Integer.valueOf(0));
    }

    @Test
    public void test2b() {
        int input = 1;
        int[] diagnosticTests = new int[]{3,3,1105,-1,9,1101,0,0,12,4,12,99,1};
        String output = new CodeComputer().execute(diagnosticTests, new int[] {input});
        Assert.assertEquals(Integer.valueOf(output), Integer.valueOf(1));
    }

}
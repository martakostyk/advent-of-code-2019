package com.martak.adventofcode.intcodecomputer;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.utils.InitialValues;
import com.martak.adventofcode.utils.ProgramInitializer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CodeComputerTest {


    @DataProvider(name = "diagnosticTests")
    public static Object[] diagnosticTests() {
        return new Object[]{
                "3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9",
                "3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1"};
    }

    @Test(dataProvider = "diagnosticTests")
    public void shouldOutput0WhenInputIs0(String diagnosticTests) {
        long[] program = ProgramInitializer.initializeProgram(diagnosticTests);
        long[] inputs = {0};
        Context context = new Context(InitialValues.POINTER, program, inputs, InitialValues.OUTPUT,
                InitialValues.RELATIVE_BASE);
        context = new CodeComputer().execute(context);
        Assert.assertEquals(Integer.valueOf(context.getOutput()), Integer.valueOf(0));
    }

    @Test(dataProvider = "diagnosticTests")
    public void shouldOutput1WhenInputIs1(String diagnosticTests) {
        long[] program = ProgramInitializer.initializeProgram(diagnosticTests);
        long[] inputs = {1};
        Context context = new Context(InitialValues.POINTER, program, inputs, InitialValues.OUTPUT,
                InitialValues.RELATIVE_BASE);
        context = new CodeComputer().execute(context);
        Assert.assertEquals(Integer.valueOf(context.getOutput()), Integer.valueOf(1));
    }

    @Test
    public void shouldOutput16DigitNumber() {
        long[] program = ProgramInitializer.initializeProgram("1102, 34915192, 34915192, 7, 4, 7, 99, 0");
        long[] inputs = {};
        Context context = new Context(InitialValues.POINTER, program, inputs, InitialValues.OUTPUT,
                InitialValues.RELATIVE_BASE);
        context = new CodeComputer().execute(context);
        System.out.println(context.getOutput());
        Assert.assertEquals(context.getOutput().length(), 16);
    }

    @Test
    public void shouldOutputNumberInTheMiddle() {
        long[] program = ProgramInitializer.initializeProgram("104, 1125899906842624, 99");
        long[] inputs = {};
        Context context = new Context(InitialValues.POINTER, program, inputs, InitialValues.OUTPUT,
                InitialValues.RELATIVE_BASE);
        context = new CodeComputer().execute(context);
        Assert.assertEquals(context.getOutput(), "1125899906842624");
    }

    @Test
    public void shouldOutputCopyOfItself() {
        long[] program = ProgramInitializer
                .initializeProgram("109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99");
        long[] inputs = {};
        Context context = new Context(InitialValues.POINTER, program, inputs, InitialValues.OUTPUT,
                InitialValues.RELATIVE_BASE);
        while (context.getPointer() < context.getCode().length) {
            context = new CodeComputer().execute(context);
        }
    }
}
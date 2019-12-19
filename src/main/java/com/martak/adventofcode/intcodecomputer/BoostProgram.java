package com.martak.adventofcode.intcodecomputer;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.utils.InitialValues;
import com.martak.adventofcode.utils.ProgramInitializer;

public class BoostProgram {

    public static void main(String[] args) {
        long[] boostProgram = ProgramInitializer.getBoostProgram();
        long[] inputs = {InitialValues.INPUT_1};
        Context context = new Context(InitialValues.POINTER, boostProgram, inputs, InitialValues.OUTPUT, InitialValues.RELATIVE_BASE);
        while (context.getPointer() < context.getCode().length) {
            context = new CodeComputer().execute(context);
            System.out.println(context.getOutput());
        }
        System.out.println("Boost keycode " + context.getOutput());
    }
}

package com.martak.adventofcode.intcodecomputer;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.utils.InitialValues;
import com.martak.adventofcode.utils.ProgramInitializer;

public class DiagnosticTests {

    public static void main(String[] args) {
        long[] diagnosticTests = ProgramInitializer.getDiagnosticTests();
        long[] inputs = {InitialValues.INPUT_5};
        Context context = new Context(InitialValues.POINTER, diagnosticTests, inputs, InitialValues.OUTPUT, InitialValues.RELATIVE_BASE);
        while (context.getPointer() < context.getCode().length) {
            context = new CodeComputer().execute(context);
        }
    }
}

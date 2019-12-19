package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;
import com.martak.adventofcode.utils.InitialValues;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpCode9Test {

    private static final OpCode OPCODE = new OpCode9();
    private static final long[] INPUTS = {0};

    @Test
    public void shouldSetRelativeBaseTo2009() {
        // given
        long[] program = {9, 0};
        Context context = new Context(InitialValues.POINTER, program, INPUTS, InitialValues.OUTPUT, 2000);
        // when
        context = OPCODE.execute(context);
        // then
        Assert.assertEquals(context.getRelativeBase(), 2009);
    }

    @Test
    public void shouldSetRelativeBaseTo2019() {
        // given
        long[] program = {109, 19};
        Context context = new Context(InitialValues.POINTER, program, INPUTS, InitialValues.OUTPUT, 2000);
        // when
        context = OPCODE.execute(context);
        // then
        Assert.assertEquals(context.getRelativeBase(), 2019);
    }
}
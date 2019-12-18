package com.martak.adventofcode.intcodecomputer.model.opcode;

import com.martak.adventofcode.intcodecomputer.model.Context;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpCode9Test {

    @Test
    public void shouldSetRelativeBaseTo2009() {
        // given
        Context context = new Context(0, new int[]{9, 0}, new long[]{0}, "", 2000);
        OpCode opCode = new OpCode9();
        // when
        context = opCode.execute(context);
        // then
        Assert.assertEquals(context.getRelativeBase(), 2009);
    }

    @Test
    public void shouldSetRelativeBaseTo2019() {
        // given
        Context context = new Context(0, new int[]{109, 19}, new long[]{0}, "", 2000);
        OpCode opCode = new OpCode9();
        // when
        context = opCode.execute(context);
        // then
        Assert.assertEquals(context.getRelativeBase(), 2019);
    }
}
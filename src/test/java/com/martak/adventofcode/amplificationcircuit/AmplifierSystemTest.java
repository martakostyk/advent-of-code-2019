package com.martak.adventofcode.amplificationcircuit;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AmplifierSystemTest {

    @Test
    public void test1() {
        // given
        int[] phaseSequence = {4,3,2,1,0};
        int[] controllerSoftware = {3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0};
        // when
        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence);
        AmplifierSystem amplifierSystem = new AmplifierSystem(amplifiers);
        String thrusterSignal = amplifierSystem.execute(controllerSoftware);
        // then
        Assert.assertEquals(thrusterSignal, "43210");
    }

    @Test
    public void test2() {
        // given
        int[] phaseSequence = {0,1,2,3,4};
        int[] controllerSoftware = {3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0};
        // when
        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence);
        AmplifierSystem amplifierSystem = new AmplifierSystem(amplifiers);
        String thrusterSignal = amplifierSystem.execute(controllerSoftware);
        // then
        Assert.assertEquals(thrusterSignal, "54321");
    }

    @Test
    public void test3() {
        // given
        int[] phaseSequence = {1,0,4,3,2};
        int[] controllerSoftware = {3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0};
        // when
        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence);
        AmplifierSystem amplifierSystem = new AmplifierSystem(amplifiers);
        String thrusterSignal = amplifierSystem.execute(controllerSoftware);
        // then
        Assert.assertEquals(thrusterSignal, "65210");
    }

}
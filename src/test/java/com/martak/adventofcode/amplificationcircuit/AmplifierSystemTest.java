package com.martak.adventofcode.amplificationcircuit;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AmplifierSystemTest {

    @Test
    public void test1() {
        String phaseSettingSequence = "43210";
        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSettingSequence);
        AmplifierSystem amplifierSystem = new AmplifierSystem(amplifiers);
        int[] controllerSoftware = new int[] {3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0};
        String thrusterSignal = amplifierSystem.execute(controllerSoftware);
        Assert.assertEquals(thrusterSignal, "43210");
    }

    @Test
    public void test2() {
        String phaseSettingSequence = "01234";
        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSettingSequence);
        AmplifierSystem amplifierSystem = new AmplifierSystem(amplifiers);
        int[] controllerSoftware =
                new int[] {3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0};
        String thrusterSignal = amplifierSystem.execute(controllerSoftware);
        Assert.assertEquals(thrusterSignal, "54321");
    }

//    @Test
//    public void test3() {
//        String phaseSettingSequence = "10432";
//        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSettingSequence);
//        AmplifierSystem amplifierSystem = new AmplifierSystem(amplifiers);
//        int[] controllerSoftware =
//                new int[] {3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0};
//        String thrusterSignal = amplifierSystem.execute(controllerSoftware);
//        Assert.assertEquals(thrusterSignal, "65210");
//    }

}
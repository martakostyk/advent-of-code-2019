package com.martak.adventofcode.amplificationcircuit;

import com.martak.adventofcode.utils.ProgramInitializer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.List;

public class AmplifierSystemTest {

    private static final BigInteger PHASE_0 = BigInteger.valueOf(0);
    private static final BigInteger PHASE_1 = BigInteger.valueOf(1);
    private static final BigInteger PHASE_2 = BigInteger.valueOf(2);
    private static final BigInteger PHASE_3 = BigInteger.valueOf(3);
    private static final BigInteger PHASE_4 = BigInteger.valueOf(4);
    private static final BigInteger PHASE_5 = BigInteger.valueOf(5);
    private static final BigInteger PHASE_6 = BigInteger.valueOf(6);
    private static final BigInteger PHASE_7 = BigInteger.valueOf(7);
    private static final BigInteger PHASE_8 = BigInteger.valueOf(8);
    private static final BigInteger PHASE_9 = BigInteger.valueOf(9);

    @Test
    public void test1() {
        // given
        BigInteger[] phaseSequence = {PHASE_4, PHASE_3, PHASE_2, PHASE_1, PHASE_0};
        String tests = "3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0";
        BigInteger[] controllerSoftware = ProgramInitializer.initializeProgram(tests);
        // when
        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence, controllerSoftware);
        BigInteger thrusterSignal = AmplifierSystem.execute(amplifiers);
        // then
        Assert.assertEquals(thrusterSignal, BigInteger.valueOf(43210));
    }

    @Test
    public void test2() {
        // given
        BigInteger[] phaseSequence = {PHASE_0, PHASE_1, PHASE_2, PHASE_3, PHASE_4};
        String tests = "3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23, 101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0";
        BigInteger[] controllerSoftware = ProgramInitializer.initializeProgram(tests);
        // when
        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence, controllerSoftware);
        BigInteger thrusterSignal = AmplifierSystem.execute(amplifiers);
        // then
        Assert.assertEquals(thrusterSignal, BigInteger.valueOf(54321));
    }

    @Test
    public void test3() {
        // given
        BigInteger[] phaseSequence = {PHASE_1, PHASE_0, PHASE_4, PHASE_3, PHASE_2};
        String tests = "3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33, 1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0";
        BigInteger[] controllerSoftware = ProgramInitializer.initializeProgram(tests);
        // when
        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence, controllerSoftware);
        BigInteger thrusterSignal = AmplifierSystem.execute(amplifiers);
        // then
        Assert.assertEquals(thrusterSignal, BigInteger.valueOf(65210));
    }

    @Test
    public void loopTest1() {
        // given
        BigInteger[] phaseSequence = {PHASE_9, PHASE_8, PHASE_7, PHASE_6, PHASE_5};
        String tests = "3, 26, 1001, 26, -4, 26, 3, 27, 1002, 27, 2, 27, 1, 27, 26, 27, 4, 27, 1001, 28, -1, 28, 1005, 28, 6, 99, 0, 0, 5";
        BigInteger[] controllerSoftware = ProgramInitializer.initializeProgram(tests);
        // when
        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence, controllerSoftware);
        BigInteger thrusterSignal = AmplifierSystem.execute(amplifiers);
        // then
        Assert.assertEquals(thrusterSignal, BigInteger.valueOf(139629729));
    }

    @Test
    public void loopTest2() {
        // given
        BigInteger[] phaseSequence = {PHASE_9, PHASE_7, PHASE_8, PHASE_5, PHASE_6};
        String tests = "3, 52, 1001, 52, -5, 52, 3, 53, 1, 52, 56, 54, 1007, 54, 5, 55, 1005, 55, 26, 1001, 54, -5, 54, 1105, 1, 12, 1, 53, 54, 53, 1008, 54, 0, 55, 1001, 55, 1, 55, 2, 53, 55, 53, 4, 53, 1001, 56, -1, 56, 1005, 56, 6, 99, 0, 0, 0, 0, 10";
        BigInteger[] controllerSoftware = ProgramInitializer.initializeProgram(tests);
        // when
        List<Amplifier> amplifiers = AmplifierFactory.getAmplifiers(phaseSequence, controllerSoftware);
        BigInteger thrusterSignal = AmplifierSystem.execute(amplifiers);
        // then
        Assert.assertEquals(thrusterSignal, BigInteger.valueOf(18216));
    }
}
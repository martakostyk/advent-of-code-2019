package com.martak.adventofcode.amplificationcircuit;


import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class PhaseSequenceGeneratorTest {

    @Test
    public void test() {
        // given
        int min = 0;
        int max = 4;
        // when
        int[][] actual = PhaseSequenceGenerator.getAllCombinations(min, max);
        // then
        Assertions.assertThat(actual.length).isEqualTo(120);
    }
}
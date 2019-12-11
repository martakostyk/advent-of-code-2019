package com.martak.adventofcode.universalorbitmap;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OrbitMapTest {

    @Test
    public void test() {
        List<String> mapData = List
                .of("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L");
        List<Orbit> orbits = OrbitMap.parse(mapData);
        int result = OrbitMap.countChecksum(orbits);
        Assert.assertEquals(result, 42);
    }
}
package com.martak.adventofcode.universalorbitmap;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrbitMapTest {

    @Test
    public void test() {
        List<String> mapData = List
                .of("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L");
        Map<String, Orbit> orbits = OrbitMap.parse(mapData);
        int result = OrbitMap.countChecksum(new ArrayList<>(orbits.values()));
        Assert.assertEquals(result, 42);
    }

    @Test
    public void test2() {
        List<String> mapData = List
                .of("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L", "K)YOU", "I)SAN");
        Map<String, Orbit> orbits = OrbitMap.parse(mapData);
        int result = OrbitMap.getToSanta(orbits);
        Assert.assertEquals(result, 4);
    }
}
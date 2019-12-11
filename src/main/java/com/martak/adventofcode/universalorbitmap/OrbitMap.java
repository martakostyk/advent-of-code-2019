package com.martak.adventofcode.universalorbitmap;

import com.martak.adventofcode.utils.CsvReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrbitMap {

    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        List<String> mapData = csvReader
                .read("C:\\Users\\Marta_Kostyk\\workspace\\adventofcode\\src\\main\\resources\\orbitmap.csv");
        List<Orbit> orbits = OrbitMap.parse(mapData);
        int result = OrbitMap.countChecksum(orbits);
        System.out.println(result);
    }

    static int countChecksum(List<Orbit> orbits) {
        int counter = 0;
        for (Orbit orbit : orbits) {
            while (orbit.getParent() != null) {
                counter++;
                orbit = orbit.getParent();
            }
        }
        return counter;
    }

    static List<Orbit> parse(List<String> mapData) {
        Map<String, Orbit> orbits = new HashMap<>();
        for (String orbitData : mapData) {
            String[] splitted = orbitData.split("\\)");
            Orbit left = new Orbit(splitted[0]);
            Orbit right = new Orbit(splitted[1]);
            orbits.put(left.getName(), left);
            orbits.put(right.getName(), right);
        }
        for (String orbitData : mapData) {
            String[] splitted = orbitData.split("\\)");
            Orbit left = orbits.get(splitted[0]);
            Orbit right = orbits.get(splitted[1]);
            right.setParent(left);
        }
        return new ArrayList<>(orbits.values());
    }
}

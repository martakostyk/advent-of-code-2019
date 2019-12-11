package com.martak.adventofcode.universalorbitmap;

import com.martak.adventofcode.utils.CsvReader;

import java.util.*;

public class OrbitMap {

    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        List<String> mapData = csvReader
                .read("C:\\Users\\Marta_Kostyk\\workspace\\adventofcode\\src\\main\\resources\\orbitmap.csv");
        Map<String, Orbit> orbits = OrbitMap.parse(mapData);
        int result = OrbitMap.countChecksum(new ArrayList<>(orbits.values()));
        System.out.println("Number of orbits " + result);
        int orbitalTransfers = OrbitMap.getToSanta(orbits);
        System.out.println("Number of orbital transfers to get to Santa " + orbitalTransfers);
    }

    static int getToSanta(Map<String, Orbit> orbits) {
        Orbit me = orbits.get("YOU");
        Orbit santa = orbits.get("SAN");
        List<Orbit> myOrbits = new ArrayList<>();
        while (me.getParent() != null) {
            me = me.getParent();
            myOrbits.add(me);
        }
        int counter = 0;
        while (santa.getParent() != null) {
            counter++;
            int index = myOrbits.indexOf(santa.getParent());
            if (index != -1) {
                counter += index - 1;
                break;
            }
            santa = santa.getParent();
        }
        return counter;
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

    static Map<String, Orbit> parse(List<String> mapData) {
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
        return orbits;
    }
}

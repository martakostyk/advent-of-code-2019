package com.martak.adventofcode.fuelrequirements;

import com.martak.adventofcode.utils.CsvReader;

import java.util.List;
import java.util.stream.Collectors;

public class FuelRequirementsCalculator {

    private static final long ZERO = 0L;

    public static void main(String[] args) {
        List<Long> masses = new CsvReader()
                .read("C:\\Users\\Marta_Kostyk\\workspace\\adventofcode\\src\\main\\resources\\input.csv")
                .stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());
        Long total = new FuelRequirementsCalculator().calculateTotal(masses);
        System.out.println(total);
    }

    private Long calculateTotal(List<Long> masses) {
        return calculate(masses, ZERO);
    }

    private Long calculate(List<Long> masses, Long fuelRequired) {
        List<Long> fuels = masses.stream()
                .filter(mass -> mass > 6)
                .map(mass -> (long) (mass / (float) 3) - 2)
                .collect(Collectors.toList());
        Long additionalFuelRequired = fuels.stream().reduce(ZERO, Long::sum);
        if (additionalFuelRequired > ZERO) {
            return calculate(fuels, fuelRequired + additionalFuelRequired);
        }
        return fuelRequired;
    }
}
// 3479429

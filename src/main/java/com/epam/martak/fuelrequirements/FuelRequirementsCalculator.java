package com.epam.martak.fuelrequirements;

import java.util.List;

public class FuelRequirementsCalculator {

    public static void main(String[] args) {
        List<Long> masses = new CsvReader()
                .read("C:\\Users\\Marta_Kostyk\\workspace\\adventofcode\\src\\main\\resources\\input.csv");
        Long total = new FuelRequirementsCalculator().calculateTotal(masses);
        System.out.println(total);
    }

    private Long calculateTotal(List<Long> masses) {
        return masses.stream()
                .filter(mass -> mass != 0)
                .map(mass -> (long) (mass / (float) 3) - 2)
                .reduce(0L, Long::sum);
    }
}

package com.martak.adventofcode.securecontainer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordValidation {

    public static void main(String[] args) {
        Range range = new Range(307237, 769058);
        PasswordValidation passwordValidation = new PasswordValidation();
        int counter = 0;
        for (int i = range.getMin(); i <= range.getMax(); i++) {
            if (passwordValidation.check(i)) {
                counter++;
            }
        }
        System.out.println("Number of valid password combinations " + counter);
    }

    public boolean check(int password) {
        if (!containsTwoTheSameAdjacentDigits(password)) {
            return false;
        }
        return containsNoDecreasingPair(password);
    }

    private boolean containsTwoTheSameAdjacentDigits(int password) {
        List<Integer> digits = Arrays.stream(Integer.toString(password).split(""))
                .map(Integer::valueOf).collect(Collectors.toList());
        int[] counters = new int[10];
        for (int i = 0; i < digits.size(); i++) {
            counters[digits.get(i)]++;
        }
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean containsNoDecreasingPair(int password) {
        char[] chars = String.valueOf(password).toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

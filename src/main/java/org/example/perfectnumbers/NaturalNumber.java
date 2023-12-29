package org.example.perfectnumbers;

import java.util.List;
import java.util.stream.IntStream;

class NaturalNumber {

    private final int number;
    private final List<Integer> factors;

    NaturalNumber(int number) {
        if (number < 1) throw new IllegalArgumentException("You must supply a natural number (positive integer)");

        this.number = number;
        this.factors = IntStream.range(1, number / 2 + 1).boxed().filter(i -> number % i == 0).toList();
    }

    Classification getClassification() {
        int factorSum = factors.stream().reduce(0, Integer::sum);

        if (factorSum < number) return Classification.DEFICIENT;
        else if (factorSum == number) return Classification.PERFECT;
        else return Classification.ABUNDANT;
    }
}
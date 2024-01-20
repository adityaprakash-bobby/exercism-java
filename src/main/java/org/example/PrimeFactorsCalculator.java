package org.example;

import java.util.ArrayList;
import java.util.List;

class PrimeFactorsCalculator {

    List<Long> calculatePrimeFactorsOf(long number) {
        List<Long> result = new ArrayList<>();

        while (number % 2 == 0) {
            result.add(2L);
            number >>= 1;
        }

        for (long i = 3; i <= (long) Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                result.add(i);
                number /= i;
            }
        }

        if (number > 2) result.add(number);

        return result;
    }
}

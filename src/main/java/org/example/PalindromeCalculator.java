package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

class PalindromeCalculator {

    SortedMap<Long, List<List<Integer>>> getPalindromeProductsWithFactors(int minFactor, int maxFactor) {
        if (minFactor > maxFactor) throw new IllegalArgumentException("invalid input: min must be <= max");

        SortedMap<Long, List<List<Integer>>> result = new TreeMap<>();
        for (int i = minFactor; i <= maxFactor; i++) {
            for (int j = i; j <= maxFactor; j++) {
                int number = i * j;
                if (isNumberPalindrome(number)) {
                    result.computeIfAbsent((long) number, n -> new ArrayList<>()).add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private boolean isNumberPalindrome(int num) {
        int temp = num;
        int reverseNum = 0;

        while (temp > 0) {
            reverseNum = reverseNum * 10 + (temp % 10);
            temp /= 10;
        }

        return reverseNum == num;
    }
}
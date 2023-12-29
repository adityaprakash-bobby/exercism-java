package org.example;

class LargestSeriesProductCalculator {
    private final String numberString;

    LargestSeriesProductCalculator(String inputNumber) {
        boolean hasCharsOtherThanDigits = inputNumber.chars().anyMatch(ch -> !Character.isDigit(ch));
        if (hasCharsOtherThanDigits) throw new IllegalArgumentException("String to search may only contain digits.");
        numberString = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits < 0) throw new IllegalArgumentException("Series length must be non-negative.");

        if (numberString.length() < numberOfDigits)
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");

        long largestProduct = 0;
        for (int i = 0; i <= numberString.length() - numberOfDigits; i++) {
            long tempProduct = 1;
            for (int j = i; j < i + numberOfDigits; j++) {
                tempProduct *= (numberString.charAt(j) - '0');
            }

            if (tempProduct > largestProduct) largestProduct = tempProduct;
        }

        return largestProduct;
    }
}
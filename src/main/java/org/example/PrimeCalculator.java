package org.example;

class PrimeCalculator {
    int nth(int nth) {
        if (nth <= 0) throw new IllegalArgumentException();

        int[] primes = new int[nth];
        primes[0] = 2;

        int ith = 1, nextNum = 3;
        boolean isPrime;
        while (ith < nth) {
            isPrime = true;
            for (int k = 0; k < ith; k++)
                if (nextNum % primes[k] == 0) {
                    isPrime = false;
                    break;
                }

            if (isPrime) {
                primes[ith] = nextNum;
                ith++;
            }

            nextNum++;
        }

        return primes[nth - 1];
    }
}

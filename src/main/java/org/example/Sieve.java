package org.example;

import java.util.List;
import java.util.stream.IntStream;

class Sieve {

    private final List<Integer> primes;

    Sieve(int maxPrime) {
        boolean[] sieve = new boolean[maxPrime + 1];

        for (int i = 0; i <= maxPrime; i++) sieve[i] = true;

        for (int i = 2; i * i <= maxPrime; i++) {
            if (sieve[i]) {
                for (int k = i * i; k <= maxPrime; k += i) sieve[k] = false;
            }
        }

        primes = IntStream.range(2, maxPrime + 1).boxed().filter(i -> sieve[i]).toList();
    }

    List<Integer> getPrimes() {
        return primes;
    }
}
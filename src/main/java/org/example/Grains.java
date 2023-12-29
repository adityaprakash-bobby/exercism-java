package org.example;

import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square >= 65 || square <= 0) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.ONE.shiftLeft(square - 1);
    }

    BigInteger grainsOnBoard() {
        return BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE);
    }
}


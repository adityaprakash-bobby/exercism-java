package org.example;

import java.util.Objects;

class Rational {

    private final int numerator;
    private final int denominator;

    Rational(int numerator, int denominator) {
        int gcd = computeGcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private static int computeGcd(int a, int b) {
        return (b == 0) ? a : computeGcd(b, a % b);
    }

    int getNumerator() {
        return numerator;
    }

    int getDenominator() {
        return denominator;
    }

    Rational add(Rational other) {
        int lcmDenominator = (other.denominator * denominator) / computeGcd(other.denominator, denominator);

        int thisMultiplier = lcmDenominator / denominator;
        int otherMultiplier = lcmDenominator / other.denominator;

        return new Rational(numerator * thisMultiplier + other.numerator * otherMultiplier, lcmDenominator);
    }

    Rational subtract(Rational other) {
        int lcmDenominator = (other.denominator * denominator) / computeGcd(other.denominator, denominator);
        int thisMultiplier = lcmDenominator / denominator;
        int otherMultiplier = lcmDenominator / other.denominator;

        return new Rational(numerator * thisMultiplier - other.numerator * otherMultiplier, lcmDenominator);
    }

    Rational multiply(Rational other) {
        return new Rational(numerator * other.numerator, denominator * other.denominator);
    }

    Rational divide(Rational other) {
        return new Rational(numerator * other.denominator, denominator * other.numerator);
    }

    Rational abs() {
        return new Rational(Math.abs(numerator), Math.abs(denominator));
    }

    Rational pow(int power) {
        Rational temp = new Rational(1, 1);

        boolean isPowerNegative = power < 0;
        for (int i = 1; i <= Math.abs(power); i++) {
            if (isPowerNegative) temp = temp.divide(this);
            else temp = temp.multiply(this);
        }

        return temp;
    }

    double exp(double exponent) {
        return Math.pow(Math.pow(exponent, 1.0 / denominator), numerator);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rational other) {
            return this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNumerator(), this.getDenominator());
    }
}


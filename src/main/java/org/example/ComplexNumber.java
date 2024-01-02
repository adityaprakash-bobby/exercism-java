package org.example;

class ComplexNumber {

    private final double real;
    private final double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    double getReal() {
        return real;
    }

    double getImaginary() {
        return imaginary;
    }

    double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(real * other.real - imaginary * other.imaginary, real * other.imaginary + imaginary * other.real);
    }

    ComplexNumber multiply(double factor) {
        return new ComplexNumber(factor * real, factor * imaginary);
    }

    ComplexNumber divide(ComplexNumber other) {
        if (other.abs() == 0) throw new IllegalArgumentException("cannot divide by 0 abs");

        return this.multiply(other.conjugate()).divide(Math.pow(other.abs(), 2));
    }

    ComplexNumber divide(double divisor) {
        if (divisor == 0) throw new IllegalArgumentException("cannot divide by 0");

        return multiply(1 / divisor);
    }

    ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    ComplexNumber exponentialOf() {
        return new ComplexNumber(Math.exp(real), 0).multiply(new ComplexNumber(Math.cos(imaginary), Math.sin(imaginary)));
    }

}

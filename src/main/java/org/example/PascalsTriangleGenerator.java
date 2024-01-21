package org.example;

class PascalsTriangleGenerator {

    int[] generateBinomialCoefficients(int exp) {
        int[] coefficients = new int[exp + 1];
        coefficients[0] = 1;

        int expCopy = exp;
        for (int i = 1; i <= exp; i++) {
            coefficients[i] = (coefficients[i - 1] * expCopy--) / i;
        }

        return coefficients;
    }

    int[][] generateTriangle(int rows) {
        int[][] pascalTriangle = new int[rows][];

        for (int i = 0; i < rows; i++) pascalTriangle[i] = generateBinomialCoefficients(i);

        return pascalTriangle;
    }

}

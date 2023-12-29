package org.example;

class Matrix {

    private final int[][] matrix;

    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");

        int[][] parsedMatrix = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] numbers = rows[i].split(" ");
            parsedMatrix[i] = new int[numbers.length];

            for (int j = 0; j < numbers.length; j++) {
                parsedMatrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        matrix = parsedMatrix;
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] result = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            result[i] = matrix[i][columnNumber - 1];
        }

        return result;
    }
}

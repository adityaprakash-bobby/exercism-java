package org.example;

class SpiralMatrixBuilder {
    int[][] buildMatrixOfSize(int size) {
        int[][] arr = new int[size][size];
        int numberMax = size * size;
        int currNumber = 1;

        int minColIdx = 0;
        int maxColIdx = size - 1;
        int minRowIdx = 0;
        int maxRowIdx = size - 1;
        while (currNumber <= numberMax) {
            int i, j;

            j = minColIdx;
            while (j <= maxColIdx) {
                arr[minRowIdx][j] = currNumber;
                currNumber++;
                j++;
            }

            minRowIdx++;
            i = minRowIdx;
            while (i <= maxRowIdx) {
                arr[i][maxColIdx] =  currNumber;
                currNumber++;
                i++;
            }

            maxColIdx--;
            j = maxColIdx;
            while (j >= minColIdx) {
                arr[maxRowIdx][j] = currNumber;
                currNumber++;
                j--;
            }

            maxRowIdx--;
            i = maxRowIdx;
            while (i >= minRowIdx) {
                arr[i][minColIdx] =  currNumber;
                currNumber++;
                i--;
            }

            minColIdx++;
        }

        return arr;
    }
}


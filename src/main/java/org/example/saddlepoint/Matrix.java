package org.example.saddlepoint;

import java.util.*;

public class Matrix {

    private final List<List<Integer>> arr;

    Matrix(List<List<Integer>> values) {
        this.arr = values;
    }

    private int getLargestInRow(int rowIdx) {
        int largest = arr.get(rowIdx).get(0);
        int size = arr.get(rowIdx).size();
        for (int j = 0; j < size; j++) {
            if (arr.get(rowIdx).get(j) > largest) largest = arr.get(rowIdx).get(j);
        }

        return largest;
    }

    private int getSmallestInColumn(int colIdx) {
        int smallest = arr.get(0).get(colIdx);
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            if (arr.get(i).get(colIdx) < smallest) smallest = arr.get(i).get(colIdx);
        }

        return smallest;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        if (arr.size() < 1) return new HashSet<>(0);

        Set<MatrixCoordinate> saddlePoints = new HashSet<>();

        Map<Integer, Integer> rowMaximum = new HashMap<>(arr.size());
        Map<Integer, Integer> columnMinimum = new HashMap<>(arr.get(0).size());

        for (int i = 0; i < arr.size(); i++) {
            rowMaximum.put(i, getLargestInRow(i));
        }

        for (int j = 0; j < arr.get(0).size(); j++) {
            columnMinimum.put(j, getSmallestInColumn(j));
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                boolean isRowMax = rowMaximum.get(i).equals(arr.get(i).get(j));
                boolean isColumnMin = columnMinimum.get(j).equals(arr.get(i).get(j));

                if (isColumnMin && isRowMax) saddlePoints.add(new MatrixCoordinate(i + 1, j + 1));
            }
        }

        return saddlePoints;
    }
}

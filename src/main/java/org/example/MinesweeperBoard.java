package org.example;

import java.util.ArrayList;
import java.util.List;

class MinesweeperBoard {

    private final int rowSize;
    private final int colSize;
    private final List<String> boardRows;

    MinesweeperBoard(List<String> boardRows) {
        this.boardRows = boardRows;
        this.rowSize = boardRows.size();

        if (rowSize != 0) this.colSize = boardRows.get(0).length();
        else colSize = 0;
    }

    List<String> withNumbers() {
        List<String> result = new ArrayList<>(boardRows.size());
        for (int i = 0; i < boardRows.size(); i++) {
            result.add(getRowWithNumbers(i));
        }

        return result;
    }


    private String getRowWithNumbers(int rowIdx) {
        StringBuilder rowResult = new StringBuilder();

        for (int j = 0; j < boardRows.get(rowIdx).length(); j++) {
            rowResult.append(getCellValue(rowIdx, j));
        }

        return rowResult.toString();
    }

    private char getCellValue(int rowIdx, int colIdx) {
        if (boardRows.get(rowIdx).charAt(colIdx) == '*') {
            return '*';
        }

        int mineCount = getMinSurroundCount(rowIdx, colIdx);

        if (mineCount != 0) return Character.forDigit(mineCount, 10);

        return ' ';
    }

    private int getMinSurroundCount(int rowIdx, int colIdx) {

        int minColumnIdx = Math.max(colIdx - 1, 0);
        int maxColumnIdx = Math.min(colIdx + 1, colSize - 1);
        int minRowIdx = Math.max(rowIdx - 1, 0);
        int maxRowIdx = Math.min(rowIdx + 1, rowSize - 1);

        int ctr = 0;
        for (int i = minRowIdx; i <= maxRowIdx; i++) {
            for (int j = minColumnIdx; j <= maxColumnIdx; j++) {
                if (boardRows.get(i).charAt(j) == '*') ctr++;
            }
        }

        return ctr;
    }
}
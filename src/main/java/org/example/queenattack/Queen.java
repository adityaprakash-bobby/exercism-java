package org.example.queenattack;

import java.util.Objects;

class Queen {

    private final int row;
    private final int column;

    Queen(int row, int column) {
        if (row < 0) throw new IllegalArgumentException("Queen position must have positive row.");
        if (row >= 8) throw new IllegalArgumentException("Queen position must have row <= 7.");
        if (column < 0) throw new IllegalArgumentException("Queen position must have positive column.");
        if (column >= 8) throw new IllegalArgumentException("Queen position must have column <= 7.");

        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queen queen = (Queen) o;
        return row == queen.row && column == queen.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}

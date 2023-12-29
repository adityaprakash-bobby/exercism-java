package org.example.queenattack;

class QueenAttackCalculator {

    private final Queen queen1;
    private final Queen queen2;

    QueenAttackCalculator(Queen queen1, Queen queen2) {
        if (queen1 == null || queen2 == null)
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        if (queen1.equals(queen2)) throw new IllegalArgumentException("Queens cannot occupy the same position.");

        this.queen1 = queen1;
        this.queen2 = queen2;
    }

    boolean canQueensAttackOneAnother() {
        return areOnDiagonals() || areOnSameColumn() || areOnSameRow();
    }

    boolean areOnSameColumn() {
        return queen1.getColumn() == queen2.getColumn();
    }

    boolean areOnSameRow() {
        return queen1.getRow() == queen2.getRow();
    }

    boolean areOnDiagonals() {
        return Math.abs(queen1.getRow() - queen2.getRow()) == Math.abs(queen1.getColumn() - queen2.getColumn());
    }
}

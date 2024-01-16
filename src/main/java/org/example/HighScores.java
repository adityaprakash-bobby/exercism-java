package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HighScores {

    private final List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = makeCopy(highScores);
    }

    private static List<Integer> makeCopy(List<Integer> input) {
        List<Integer> temp = new ArrayList<>(Collections.nCopies(input.size(), 0));
        Collections.copy(temp, input);

        return temp;
    }

    List<Integer> scores() {
        return makeCopy(highScores);
    }

    Integer latest() {
        return highScores.get(highScores.size() - 1);
    }

    Integer personalBest() {
        return personalTopThree().get(0);
    }

    List<Integer> personalTopThree() {
        return highScores.stream().sorted(Collections.reverseOrder()).limit(3).toList();
    }

}


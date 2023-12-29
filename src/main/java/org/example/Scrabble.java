package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Scrabble {

    private static final Map<Integer, Integer> scoreMap = new HashMap<>(26);
    private static final String[] letters = {"AEIOULNRST", "DG", "BCMP", "FHVWY", "K", "JX", "QZ"};
    private static final int[] scores = {1, 2, 3, 4, 5, 8, 10};

    static {
        IntStream.range(0, letters.length).forEach(idx -> letters[idx].chars().forEach(letter -> scoreMap.put(letter, scores[idx])));
    }

    private final int score;

    Scrabble(String word) {

        this.score = word.toUpperCase().chars().reduce(0, (score, ch) -> score + scoreMap.get(ch));
    }

    int getScore() {
        return score;
    }

}

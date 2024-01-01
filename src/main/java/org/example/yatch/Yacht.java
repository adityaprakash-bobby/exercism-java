package org.example.yatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Yacht {

    private final int score;

    Yacht(int[] dice, YachtCategory yachtCategory) {

        List<Integer> diceAsList = new ArrayList<>();
        for (int num : dice) diceAsList.add(num);

        score = switch (yachtCategory) {
            case ONES -> onesScore(diceAsList);
            case TWOS -> twosScore(diceAsList);
            case THREES -> threesScore(diceAsList);
            case FOURS -> foursScore(diceAsList);
            case FIVES -> fivesScore(diceAsList);
            case SIXES -> sixesScore(diceAsList);
            case FULL_HOUSE -> fullHouseScore(diceAsList);
            case FOUR_OF_A_KIND -> fourOfAKindScore(diceAsList);
            case LITTLE_STRAIGHT -> littleStraightScore(diceAsList);
            case BIG_STRAIGHT -> bigStraightScore(diceAsList);
            case CHOICE -> choiceScore(diceAsList);
            case YACHT -> yachtScore(diceAsList);
            default -> 0;
        };
    }

    int score() {
        return score;
    }

    private int onesScore(List<Integer> dice) {
        return (int) dice.stream().filter(i -> i == 1).count() * 1;
    }

    private int twosScore(List<Integer> dice) {
        return (int) dice.stream().filter(i -> i == 2).count() * 2;
    }

    private int threesScore(List<Integer> dice) {
        return (int) dice.stream().filter(i -> i == 3).count() * 3;
    }

    private int foursScore(List<Integer> dice) {
        return (int) dice.stream().filter(i -> i == 4).count() * 4;
    }

    private int fivesScore(List<Integer> dice) {
        return (int) dice.stream().filter(i -> i == 5).count() * 5;
    }

    private int sixesScore(List<Integer> dice) {
        return (int) dice.stream().filter(i -> i == 6).count() * 6;
    }

    private int fullHouseScore(List<Integer> dice) {
        return dice.stream().distinct().count() == 2 && dice.stream().allMatch(n -> Collections.frequency(dice, n) >= 2)
                ? dice.stream().reduce(0, Integer::sum) : 0;
    }

    private int fourOfAKindScore(List<Integer> dice) {
        return dice.stream().filter(i -> Collections.frequency(dice, i) >= 4).limit(4).mapToInt(i -> i).sum();
    }

    private int littleStraightScore(List<Integer> dice) {
        return dice.stream().reduce(0, Integer::sum) == 15 && dice.stream().distinct().count() == 5 ? 30 : 0;
    }

    private int bigStraightScore(List<Integer> dice) {
        return dice.stream().reduce(0, Integer::sum) == 20 && dice.stream().distinct().count() == 5 ? 30 : 0;
    }

    private int choiceScore(List<Integer> dice) {
        return dice.stream().reduce(0, Integer::sum);
    }

    private int yachtScore(List<Integer> dice) {
        return dice.stream().distinct().count() == 1 ? 50 : 0;
    }
}
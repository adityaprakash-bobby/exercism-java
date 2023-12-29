package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Random;

class DnDCharacter {

    private static final Random random = new Random();

    private final int strength = ability(rollDice());
    private final int dexterity = ability(rollDice());
    private final int constitution = ability(rollDice());
    private final int intelligence = ability(rollDice());
    private final int wisdom = ability(rollDice());
    private final int charisma = ability(rollDice());
    private final int hitpoints = 10 + modifier(constitution);

    int ability(List<Integer> scores) {
        return scores.stream().sorted(Collections.reverseOrder()).limit(3).reduce(0, Integer::sum);
    }

    List<Integer> rollDice() {
        return random.ints(4, 1, 7).boxed().toList();
    }

    int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }
}

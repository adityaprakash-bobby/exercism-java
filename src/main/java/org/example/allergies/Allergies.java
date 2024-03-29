package org.example.allergies;

import java.util.Arrays;
import java.util.List;

class Allergies {

    private final int score;

    Allergies(int score) {
        this.score = score;
    }

    boolean isAllergicTo(Allergen allergen) {
        return (score & allergen.getScore())  == allergen.getScore();
    }

    List<Allergen> getList() {
        return Arrays.stream(Allergen.values()).filter(this::isAllergicTo).toList();
    }
}


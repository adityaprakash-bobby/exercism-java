package org.example;

import java.util.Arrays;

class Acronym {

    private String acronym;

    Acronym(String phrase) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(phrase.replaceAll("[-_]", " ").split("\\s+"))
                .forEach(word -> builder.append(Character.toUpperCase(word.charAt(0))));

        this.acronym = builder.toString();
    }

    String get() {
        return acronym;
    }
}
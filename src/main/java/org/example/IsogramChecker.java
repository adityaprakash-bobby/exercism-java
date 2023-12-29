package org.example;

public class IsogramChecker {

    boolean isIsogram(String phrase) {
        char[] characters = phrase.toLowerCase().toCharArray();

        for (int i = 0; i < characters.length; i++) {
            char ch = characters[i];

            if (!Character.isLetter(ch)) continue;
            else if (i + 1 != characters.length && Character.isLetter(characters[i + 1]) && ch == characters[i + 1])
                return false;
        }

        return true;
    }
}

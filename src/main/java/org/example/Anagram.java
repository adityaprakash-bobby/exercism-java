package org.example;

import java.util.List;

class Anagram {

    private final String word;

    public Anagram(String word) {
        this.word = word.toLowerCase();
    }

    private boolean isAnagram(String otherWord) {
        if (otherWord.length() != word.length()) return false;
        if (otherWord.toLowerCase().equals(word)) return false;

        int xor = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            xor ^= ch - 'a';
        }

        for (int i = 0; i < otherWord.length(); i++) {
            char ch = otherWord.toLowerCase().charAt(i);
            xor ^= ch - 'a';
        }

        return xor == 0;
    }

    public List<String> match(List<String> candidates) {
        return candidates.stream().filter(this::isAnagram).toList();
    }

}

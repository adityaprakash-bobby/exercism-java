package org.example;

import java.util.Arrays;

public class Transpose {
    public String transpose(String toTranspose) {
        String[] words = toTranspose.split("\n");
        padWords(words);

        int height = Arrays.stream(words).mapToInt(String::length).max().orElse(0);
        int width = words.length;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i < words[j].length()) result.append(words[j].charAt(i));
            }
            if (i != height - 1) result.append("\n");
        }

        return result.toString();
    }

    private void padWords(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (words[i].length() < words[j].length()) {
                    words[i] = String.format("%-" + words[j].length() + "s", words[i]);
                }
            }
        }
    }
}

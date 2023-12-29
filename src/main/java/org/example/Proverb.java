package org.example;

class Proverb {

    private final String proverb;

    Proverb(String[] words) {
        if (words.length == 0) {
            proverb = "";
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            String line = String.format("For want of a %s the %s was lost.\n", words[i], words[i + 1]);
            result.append(line);
        }

        result.append(String.format("And all for the want of a %s.", words[0]));
        proverb = result.toString();
    }

    String recite() {
        return proverb;
    }
}

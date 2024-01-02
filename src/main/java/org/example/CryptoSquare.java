package org.example;

class CryptoSquare {

    private final String plaintext;
    private final String ciphertext;

    CryptoSquare(String plaintext) {
        this.plaintext = plaintext;

        StringBuilder normalizedText = new StringBuilder();
        plaintext.chars().filter(Character::isLetterOrDigit).map(Character::toLowerCase).forEach(normalizedText::appendCodePoint);

        int columnSize = (int) Math.ceil(Math.sqrt(normalizedText.length()));
        int rowSize = (columnSize - 1) * columnSize < normalizedText.length() ? columnSize : columnSize - 1;

        // pad the string
        normalizedText.append(" ".repeat(columnSize * rowSize - normalizedText.length()));

        // build ciphertext
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < columnSize; j++) {
            for (int i = 0; i < rowSize; i++) {
                char ch = normalizedText.charAt(i * columnSize + j);
                result.append(ch);
            }

            if (j != columnSize - 1) result.append(" ");
        }

        this.ciphertext = result.toString();
    }

    String getCiphertext() {
        return ciphertext;
    }
}

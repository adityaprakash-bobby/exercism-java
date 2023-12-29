package org.example;

class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    private int rotateChar(int codePoint) {
        if (!Character.isLetter(codePoint)) return codePoint;

        char firstChar = Character.isLowerCase(codePoint) ? 'a' : 'A';

        return firstChar + (shiftKey + codePoint - firstChar) % 26;
    }

    String rotate(String data) {
        StringBuilder result = new StringBuilder();

        data.codePoints().forEach(ch -> {
            result.appendCodePoint(rotateChar(ch));
        });

        return result.toString();
    }

}


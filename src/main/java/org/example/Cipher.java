package org.example;

import java.util.Random;

public class Cipher {

    private static Random rand = new Random();
    private final String key;

    public Cipher() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++)
            sb.appendCodePoint('a' + rand.nextInt(0,26));

        this.key = sb.toString();

    }

    public Cipher(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String normalizedKey(int inputLength) {
        int keyLength = key.length();

        if (inputLength <= keyLength)
            return key.substring(0, inputLength);

        int repeatTimes = inputLength / keyLength;
        int overflowChars = inputLength % keyLength;

        return key.repeat(repeatTimes) + key.substring(0, overflowChars);
    }

    public String encode(String plainText) {
        String normalizedKey = normalizedKey(plainText.length());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            int shift =  normalizedKey.charAt(i) - 'a';
            sb.appendCodePoint('a' + (ch - 'a' + shift) % 26);
        }

        return sb.toString();
    }

    public String decode(String cipherText) {
        String normalizedKey = normalizedKey(cipherText.length());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            int shift =  normalizedKey.charAt(i) - 'a';
            sb.appendCodePoint('a' + (26 + ch - 'a' - shift) % 26);
        }

        return sb.toString();
    }
}

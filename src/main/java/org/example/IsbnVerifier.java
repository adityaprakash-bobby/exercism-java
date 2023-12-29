package org.example;

class IsbnVerifier {

    private static int FORMAT_SIZE = 10;

    boolean isValid(String stringToVerify) {
        String stringOnlyNumbers = stringToVerify.replace("-", "");

        if (stringOnlyNumbers.length() != 10) return false;

        int sum = 0;
        for (int i = 0; i < FORMAT_SIZE; i++) {
            char ch = stringOnlyNumbers.charAt(i);

            if (Character.isDigit(ch)) sum += (ch - '0') * (FORMAT_SIZE - i);
            else if (Character.isLetter(ch) && ch == 'X') sum += 10;
            else return false;
        }

        return sum % 11 == 0;
    }

}
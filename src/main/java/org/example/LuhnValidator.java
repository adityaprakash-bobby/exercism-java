package org.example;

class LuhnValidator {

    boolean isValid(String candidate) {
        int pos = 0;
        int digitSum = 0;
        for (int i = candidate.length() - 1; i >= 0; i--) {
            char ch = candidate.charAt(i);

            if (!(Character.isSpaceChar(ch) || Character.isDigit(ch))) return false;

            if (!Character.isDigit(ch)) continue;

            if (pos % 2 == 1) {
                int toAdd = Character.getNumericValue(ch) * 2;
                digitSum += toAdd > 9 ? toAdd - 9 : toAdd;
            } else {
                digitSum += Character.getNumericValue(ch);
            }

            pos++;
        }

        return pos > 1 && digitSum % 10 == 0;
    }
}

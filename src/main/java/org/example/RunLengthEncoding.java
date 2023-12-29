package org.example;

public class RunLengthEncoding {
    String encode(String data) {
        StringBuilder result = new StringBuilder();

        int ctr = 0;
        for (int i = 0; i < data.length(); i++) {
            ctr++;
            char currChar = data.charAt(i);

            if (i + 1 == data.length() || data.charAt(i + 1) != currChar) {
                if (ctr != 1) result.append(ctr);
                result.append(currChar);
                ctr = 0;
            }
        }

        return result.toString();
    }

    String decode(String data) {
        StringBuilder result = new StringBuilder();

        int repeat = 0;
        for (int i = 0; i < data.length(); i++) {
            char currCh = data.charAt(i);
            int prevChIdx = i - 1;

            if (Character.isDigit(currCh)) {
                repeat = repeat * 10 + (currCh - '0');
                continue;
            }

            if (prevChIdx >= 0 && Character.isDigit(data.charAt(prevChIdx))) {
                while (repeat-- > 1) {
                    result.append(currCh);
                }

                repeat = 0;
            }

            if (Character.isLetter(currCh) || Character.isSpaceChar(currCh)) {
                result.append(currCh);
            }

        }


        return result.toString();
    }
}

package org.example;

import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        int matrixSize = 2 * (a - 'A') + 1;
        String[] result = new String[matrixSize];
        for (char ch = 'A'; ch <= a; ch++) {
            // build line
            int leftOffset = (a - ch);
            int rightOffset = matrixSize - 1 - leftOffset;

            StringBuilder line = new StringBuilder(" ".repeat(matrixSize));
            line.setCharAt(leftOffset, ch);
            line.setCharAt(rightOffset, ch);

            // add line to array
            int bottomOffset = ch - 'A';
            int topOffset = matrixSize - 1 - bottomOffset;
            result[topOffset] = line.toString();
            result[bottomOffset] = line.toString();
        }
        return List.of(result);
    }

}


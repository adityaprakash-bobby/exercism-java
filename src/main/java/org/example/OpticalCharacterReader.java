package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class OpticalCharacterReader {

    private static final int characterWidth = 3;

    private static final int characterHeight = 4;

    private static final String zeroString = " _ " + "| |" + "|_|" + "   ";

    private static final String oneString = "   " + "  |" + "  |" + "   ";

    private static final String twoString = " _ " + " _|" + "|_ " + "   ";

    private static final String threeString = " _ " + " _|" + " _|" + "   ";

    private static final String fourString = "   " + "|_|" + "  |" + "   ";

    private static final String fiveString = " _ " + "|_ " + " _|" + "   ";

    private static final String sixString = " _ " + "|_ " + "|_|" + "   ";

    private static final String sevenString = " _ " + "  |" + "  |" + "   ";

    private static final String eightString = " _ " + "|_|" + "|_|" + "   ";

    private static final String nineString = " _ " + "|_|" + " _|" + "   ";

    private static char ocrInputByGrid(List<String> input, int gridRowIdx, int gridColumnIdx) {
        int startRow = gridRowIdx * characterHeight;
        int endRow = (gridRowIdx + 1) * characterHeight - 1;
        int startColumn = gridColumnIdx * characterWidth;
        int endColumn = (gridColumnIdx + 1) * characterWidth - 1;

        List<String> number = new ArrayList<>(characterHeight);
        IntStream
                .range(startRow, endRow + 1)
                .forEach(rowIdx -> number.add(input.get(rowIdx).substring(startColumn, endColumn + 1)));
        String numberString = number.stream().collect(Collectors.joining());

        return switch (numberString) {
            case zeroString -> '0';
            case oneString -> '1';
            case twoString -> '2';
            case threeString -> '3';
            case fourString -> '4';
            case fiveString -> '5';
            case sixString -> '6';
            case sevenString -> '7';
            case eightString -> '8';
            case nineString -> '9';
            default -> '?';
        };
    }

    String parse(List<String> input) {
        if (input.size() % characterHeight != 0)
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");


        if (input.get(0).length() % characterWidth != 0)
            throw new IllegalArgumentException("Number of input columns must be a positive multiple of 3");

        int gridRows = input.size() / characterHeight;
        int gridColumns = input.get(0).length() / characterWidth;

        List<String> rowWiseResults = new ArrayList<>();
        for (int row = 0; row < gridRows; row++) {
            StringBuilder rowResult = new StringBuilder();
            for (int column = 0; column < gridColumns; column++)
                rowResult.append(ocrInputByGrid(input, row, column));

            rowWiseResults.add(rowResult.toString());
        }

        return String.join(",", rowWiseResults);
    }
}
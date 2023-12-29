package org.example;

class BottleSong {

    private String numToString(int num) {
        String str = switch (num) {
            case 0 -> "No";
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            case 10 -> "Ten";
            default -> throw new IllegalStateException("Unexpected value: " + num);
        };

        return str;
    }

    private String getVerse(int currBottles, int fallenBottles) {
        String currBottlesStr = numToString(currBottles);
        String fallenBottlesStr = numToString(fallenBottles).toLowerCase();
        String remainingBottlesStr = numToString(currBottles - fallenBottles).toLowerCase();

        boolean isCurrBottlesPlural = currBottles > 1;
        boolean isRemainingBottlesPlural = (currBottles - fallenBottles) > 1 || (currBottles - fallenBottles) == 0;
        boolean isFallenBottlesPlural = fallenBottles > 1;

        String line12 = String.format("%s green %s hanging on the wall", currBottlesStr, isCurrBottlesPlural ? "bottles" : "bottle");
        String line3 = String.format("And if %s green %s should accidentally fall", fallenBottlesStr, isFallenBottlesPlural ? "bottles" : "bottle");
        String line4 = String.format("There'll be %s green %s hanging on the wall", remainingBottlesStr, isRemainingBottlesPlural ? "bottles" : "bottle");

        return String.format("%s,\n%s,\n%s,\n%s.\n", line12, line12, line3, line4);
    }

    String recite(int startBottles, int takeDown) {
        StringBuilder result = new StringBuilder();
        for (int i = startBottles; i > (startBottles - takeDown); i--) {
            result.append(getVerse(i, 1));

            if (takeDown != (startBottles - i + 1)) {
                result.append("\n");
            }
        }

        return result.toString();
    }

}

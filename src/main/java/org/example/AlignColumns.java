package org.example;

import java.util.HashMap;
import java.util.Map;

public class AlignColumns {

    private static Map<Integer, Integer> getColumnWidths(String[] input) {
        Map<Integer, Integer> columnWidths = new HashMap(0);
        for (String str : input) {
            String[] splitStrings = str.split("\\$");
            for (int i = 0; i < splitStrings.length; i++) {
                columnWidths.put(i, Math.max(columnWidths.getOrDefault(i, 0), splitStrings[i].length()));
            }
        }

        return columnWidths;
    }

    private static String formatWord(String input, int columnLength, String justification) {
        if (justification == "left") return String.format("%-" + columnLength + "s", input);
        if (justification == "right") return String.format("%" + columnLength + "s", input);

        int leftPad = Math.round((columnLength - input.length()) / 2);
        int rightPad = columnLength - input.length() - leftPad;

        return " ".repeat(leftPad) + input + " ".repeat(rightPad);
    }

    public static String[] formatText(String[] input, String justification) {
        String[] result = new String[input.length];
        Map<Integer, Integer> columnWidthsByIndex = getColumnWidths(input);

        for (int k = 0; k < input.length; k++) {
            String str = input[k];
            String[] splitStrings = str.split("\\$");
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < splitStrings.length; i++) {
                res.append(formatWord(splitStrings[i], columnWidthsByIndex.get(i), justification));

                if (i != splitStrings.length - 1) {
                    res.append(' ');
                }
            }

            result[k] = res.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        String[] input = {
                "Given$a$text$file$of$many$lines",
                "where$fields$within$a$line$",
                "are$delineated$by$a$single$\"dollar\"$character",
                "write$a$program",
                "that$aligns$each$column$of$fields$",
                "by$ensuring$that$words$in$each$",
                "column$are$separated$by$at$least$one$space.",
                "Further,$allow$for$each$word$in$a$column$to$be$either$left$",
                "justified,$right$justified",
                "or$center$justified$within$its$column."
        };

        System.out.println(getColumnWidths(input));
        String[] res = formatText(input, "center");

        for (String r : res) {
            System.out.println(r);
        }


        String[] res2 = formatText(input, "left");

        for (String r : res2) {
            System.out.println(r);
        }

        String[] res3 = formatText(input, "right");

        for (String r : res3) {
            System.out.println(r);
        }

    }
}

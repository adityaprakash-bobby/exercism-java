package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LogLevels {

    private static final Set<String> logLevels = new HashSet<>(Arrays.asList("info", "warning", "error"));

    public static String message(String logLine) {

        int closingBracketIdx = -1;

        for (int i = 0; i < logLine.length(); i++) {
            char ch = logLine.charAt(i);
            if (ch == ']') {
                closingBracketIdx = i;
                break;
            }
        }

        return logLine.substring(closingBracketIdx + 2, logLine.length()).trim();
    }

    public static String logLevel(String logLine) {
        int openingBracketIdx = -1, closingBracketIdx = -1;

        for (int i = 0; i < logLine.length(); i++) {
            char ch = logLine.charAt(i);

            if (ch == '[') {
                openingBracketIdx = i;
            } else if (ch == ']') {
                closingBracketIdx = i;
                break;
            }
        }

        return logLine.substring(openingBracketIdx + 1, closingBracketIdx).toLowerCase();
    }

    public static String reformat(String logLine) {
        String msg = message(logLine);
        String level = logLevel(logLine);

        return msg + " (" + level + ")";
    }

    public static void main(String[] args) {
        String[] tests = {"[INFO] test", "[ERROR] test message \r \n"};

        for (String test : tests) {
            System.out.println(logLevel(test));
            System.out.println(message(test));
            System.out.println(reformat(test));
        }

    }
}

package org.example;

class MicroBlog {
    public String truncate(String input) {
        int totalCodePoints = input.codePointCount(0, input.length());
        int minCodePointsForTruncate = Math.min(5, totalCodePoints);

        return input.substring(0, input.offsetByCodePoints(0, minCodePointsForTruncate));
    }

}
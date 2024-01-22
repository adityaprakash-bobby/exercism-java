package org.example;

import java.util.Set;
import java.util.Stack;

class BracketChecker {

    private static final Set<Character> openBrackets = Set.of('{', '[', '(');
    private static final Set<Character> closedBrackets = Set.of('}', ']', ')');
    private boolean isBalanced = false;

    BracketChecker(String expression) {
        String sanitized = expression.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> isClosedBracket(c) || isOpeningBracket(c))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sanitized.length(); i++) {
            char ch = sanitized.charAt(i);

            if (isOpeningBracket(ch)) stack.add(ch);
            
            if (isClosedBracket(ch)) {
                if (stack.isEmpty() || stack.peek() != getCorrespondingOpeningBracket(ch)) return;
                else stack.pop();

            }
        }

        isBalanced = stack.isEmpty();
    }

    private static boolean isOpeningBracket(char ch) {
        return openBrackets.stream().anyMatch(c -> c == ch);
    }

    private static boolean isClosedBracket(char ch) {
        return closedBrackets.stream().anyMatch(c -> c == ch);
    }

    private static char getCorrespondingOpeningBracket(char ch) {
        return switch (ch) {
            case '}' -> '{';
            case ')' -> '(';
            case ']' -> '[';
            default -> throw new IllegalArgumentException("Unsupported opening bracket");
        };
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        return isBalanced;
    }

}
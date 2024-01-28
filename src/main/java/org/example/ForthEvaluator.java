package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ForthEvaluator {

    private static final String SUBSTITUTION_REGEX = "^:\\s([a-zA-Z0-9/+*-]+)\\s(([a-zA-Z0-9/+*-]+\\s)+);$";

    private static final Set<String> validManipulationKeywords = Set.of("dup", "drop", "over", "swap");
    private static final Set<String> validArithmeticKeywords = Set.of("+", "-", "*", "/");

    private static boolean isSubstitutionDefinition(String input) {
        return Pattern.matches(SUBSTITUTION_REGEX, input);
    }

    private static boolean isManipulationKeyword(String word) {
        return validManipulationKeywords.contains(word.toLowerCase());
    }

    private static boolean isValidArithmeticKeyword(String word) {
        return validArithmeticKeywords.contains(word);
    }

    private static boolean isValidNumeric(String word) {
        try {
            Integer.parseInt(word);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    // arithmetic operations
    private static void add(Stack<Integer> stack) {
        if (stack.size() < 2)
            throw new IllegalArgumentException("Addition requires that the stack contain at least 2 values");

        int sum = stack.pop() + stack.pop();
        stack.push(sum);
    }

    private static void subtract(Stack<Integer> stack) {
        if (stack.size() < 2)
            throw new IllegalArgumentException("Subtraction requires that the stack contain at least 2 values");

        int subtract = -1 * stack.pop() + stack.pop();
        stack.push(subtract);
    }

    private static void multiply(Stack<Integer> stack) {
        if (stack.size() < 2)
            throw new IllegalArgumentException("Multiplication requires that the stack contain at least 2 values");

        int multiply = stack.pop() * stack.pop();
        stack.push(multiply);
    }

    private static void division(Stack<Integer> stack) {
        if (stack.size() < 2)
            throw new IllegalArgumentException("Division requires that the stack contain at least 2 values");

        int denominator = stack.pop();
        int numerator = stack.pop();

        if (denominator == 0)
            throw new IllegalArgumentException("Division by 0 is not allowed");

        stack.push(numerator / denominator);
    }

    // stack manipulations
    private static void dup(Stack<Integer> stack) {
        if (stack.empty())
            throw new IllegalArgumentException("Duplicating requires that the stack contain at least 1 value");

        stack.add(stack.peek());
    }

    private static void drop(Stack<Integer> stack) {
        if (stack.empty())
            throw new IllegalArgumentException("Dropping requires that the stack contain at least 1 value");

        stack.pop();
    }

    private static void swap(Stack<Integer> stack) {
        if (stack.size() < 2)
            throw new IllegalArgumentException("Swapping requires that the stack contain at least 2 values");

        int a = stack.pop();
        int b = stack.pop();

        stack.push(a);
        stack.push(b);
    }

    public static void over(Stack<Integer> stack) {
        if (stack.size() < 2)
            throw new IllegalArgumentException("Overing requires that the stack contain at least 2 values");

        int a = stack.pop();
        int b = stack.pop();

        stack.push(b);
        stack.push(a);
        stack.push(b);
    }


    private static void applyArithmeticToken(Stack<Integer> stack, String token) {
        switch (token) {
            case "+" -> add(stack);
            case "-" -> subtract(stack);
            case "*" -> multiply(stack);
            case "/" -> division(stack);
            default -> throw new IllegalArgumentException("Unsupported arithmetic operation");
        }
    }

    private static void applyManipulationToken(Stack<Integer> stack, String token) {
        switch (token) {
            case "dup" -> dup(stack);
            case "drop" -> drop(stack);
            case "swap" -> swap(stack);
            case "over" -> over(stack);
            default -> throw new IllegalArgumentException("Unsupported manipulation operation");
        }
    }

    private static void applyNumericToken(Stack<Integer> stack, String token) {
        try {
            stack.push(Integer.parseInt(token));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not a valid number. Cannot be pushed to stack");
        }
    }

    private static void applyToken(Stack<Integer> stack, String token) {
        if (isManipulationKeyword(token))
            applyManipulationToken(stack, token);
        else if (isValidArithmeticKeyword(token))
            applyArithmeticToken(stack, token);
        else if (isValidNumeric(token))
            applyNumericToken(stack, token);
        else
            throw new IllegalArgumentException("No definition available for operator \"" + token + "\"");
    }

    private static Substitution getSubstitutionValue(String input) {
        Pattern p = Pattern.compile(SUBSTITUTION_REGEX);
        Matcher m = p.matcher(input);

        String replace, with;
        if (m.find()) {
            replace = m.group(1);
            with = m.group(2).trim();

            if (isValidNumeric(replace))
                throw new IllegalArgumentException("Cannot redefine numbers");

            return new Substitution(replace, with);
        }

        return null;
    }

    public static void main(String[] args) {
        ForthEvaluator fe = new ForthEvaluator();
        System.out.println(fe.evaluateProgram(List.of("1 2 dup swap over - + -")));

//        System.out.println(getSubstitutionValue(": asd asd asd fsd ;"));
    }

    private String buildEffectiveEvaluateString(String evaluateString, List<String> substitutions) {

        Map<String, String> subtitutionMap = new HashMap<>();

        String effectiveEvaluateString = evaluateString;
        String replace, with;
        for (String substitution : substitutions) {
            Substitution s = getSubstitutionValue(substitution);

            if (s == null) throw new IllegalArgumentException("Invalid substitution");

            replace = s.replace;
            with = s.with;

            if (subtitutionMap.containsKey(replace))
                with = with.replace(replace, subtitutionMap.get(replace));

            String[] withTokens = with.split("\\s+");
            for (String withToken : withTokens) {
                if (subtitutionMap.containsKey(withToken))
                    with = with.replace(withToken, subtitutionMap.get(withToken));
            }

            subtitutionMap.put(s.replace, with);
        }

        for (Map.Entry<String, String> s : subtitutionMap.entrySet()) {
            replace = s.getKey();
            with = s.getValue();
            effectiveEvaluateString = effectiveEvaluateString.replace(replace, with);
        }

        return effectiveEvaluateString;
    }

    List<Integer> evaluateProgram(List<String> input) {
        String toBeEvaluated = null;
        List<String> substitutions = new ArrayList<>();
        for (String i: input) {
            if (isSubstitutionDefinition(i)) substitutions.add(i.toLowerCase());

            toBeEvaluated = i.toLowerCase();
        }

        toBeEvaluated = buildEffectiveEvaluateString(toBeEvaluated, substitutions);

        String[] tokens = toBeEvaluated.split("\\s+");
        Stack<Integer> stack = new Stack<>();
        Arrays.stream(tokens).forEach(token -> applyToken(stack, token));

        return stack;
    }

    private record Substitution(String replace, String with) {
    }
}

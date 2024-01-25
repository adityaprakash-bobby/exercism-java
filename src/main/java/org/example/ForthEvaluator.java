package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ForthEvaluator {

    private static final String SUBSTITUTION_REGEX = "^:\\s([a-zA-Z-]+)\\s([a-zA-Z]+)\\s;$";

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
            case "+":
                add(stack);
                break;
            case "-":
                subtract(stack);
                break;
            case "*":
                multiply(stack);
                break;
            case "/":
                division(stack);
            default:
                throw new IllegalArgumentException("Unsupported arithmetic operation");
        }
    }

    private static void applyManipulationToken(Stack<Integer> stack, String token) {
        switch (token) {
            case "dup":
                dup(stack);
                break;
            case "drop":
                drop(stack);
                break;
            case "swap":
                swap(stack);
                break;
            case "over":
                over(stack);
                break;
            default:
                throw new IllegalArgumentException("Unsupported manipulation operation");
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
            throw new IllegalArgumentException("invalid keyword token `" + token + "` found");
    }

    private static String getSubstitutionValue(String input) {
        Pattern p = Pattern.compile(SUBSTITUTION_REGEX);
        Matcher m = p.matcher(input);
        if (m.find()) {
            
        }
    }
    List<Integer> evaluateProgram(List<String> input) {


        if (input.size() == 0) return Collections.emptyList();

        String[] tokens = input.get(0).split(" ");
        Stack<Integer> stack = new Stack<>();
        Arrays.stream(tokens).forEach(token -> applyToken(stack, token));

        return stack;
    }


//    public static void main(String[] args) {
//        ForthEvaluator fe = new ForthEvaluator();
//        System.out.println(fe.evaluateProgram(List.of("1 2 dup swap over - + -")));
//
//    }
}

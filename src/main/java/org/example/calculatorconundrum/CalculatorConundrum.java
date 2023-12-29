package org.example.calculatorconundrum;

public class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        if (null == operation) throw new IllegalArgumentException("Operation cannot be null");

        if ("".equals(operation)) throw new IllegalArgumentException("Operation cannot be empty");

        return switch (operation) {
            case "+" -> String.format("%d %s %d = %d", operand1, operation, operand2, operand1 + operand2);
            case "*" -> String.format("%d %s %d = %d", operand1, operation, operand2, operand1 * operand2);
            case "/" -> {
                try {
                    yield String.format("%d %s %d = %d", operand1, operation, operand2, operand1 / operand2);
                } catch (ArithmeticException ae) {
                    throw new IllegalOperationException("Division by zero is not allowed", ae);
                }
            }
            default -> throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        };
    }
}


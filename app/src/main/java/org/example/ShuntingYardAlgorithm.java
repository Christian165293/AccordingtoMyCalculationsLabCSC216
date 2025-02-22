package org.example;

import java.util.*;

public class ShuntingYardAlgorithm {
    public static String infixToPostfix(String expression) {
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);

        StringBuilder output = new StringBuilder();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);

            // Ignore whitespace
            if (Character.isWhitespace(token)) {
                continue;
            }

            // If token is a number, add it to output
            if (Character.isDigit(token)) {
                output.append(token);
            }
            // If token is an operator
            else if (precedence.containsKey(token)) {
                while (!operators.isEmpty() && precedence.getOrDefault(operators.peek(), 0) >= precedence.get(token)) {
                    output.append(operators.pop());
                }
                operators.push(token);
            }
            // Left parenthesis
            else if (token == '(') {
                operators.push(token);
            }
            // Right parenthesis
            else if (token == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.append(operators.pop());
                }
                if (!operators.isEmpty() && operators.peek() == '(') {
                    operators.pop();
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses in expression.");
                }
            }
        }

        // Pop any remaining operators
        while (!operators.isEmpty()) {
            char op = operators.pop();
            if (op == '(' || op == ')') {
                throw new IllegalArgumentException("Mismatched parentheses in expression.");
            }
            output.append(op);
        }

        return output.toString();
    }
}

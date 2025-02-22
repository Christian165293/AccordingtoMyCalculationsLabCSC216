package org.example;

import java.util.Stack;

public class Calculator {
    public static double evaluate(String infix) {
        String postFix = ShuntingYardAlgorithm.infixToPostfix(infix);
        return evaluatePostfix(postFix);
    }

    public static double evaluatePostfix(String postFix) {
        Stack<Double> numbers = new Stack<>();
        for (int i = 0; i < postFix.length(); i++) {
            switch (postFix.charAt(i)) {
                case '-':
                    double subtrahend = numbers.pop();
                    double minuend = numbers.pop();
                    numbers.add(minuend - subtrahend);
                    break;
                case '+':
                    numbers.add(numbers.pop() + numbers.pop());
                    break;
                case '/':
                    double divisor = numbers.pop();
                    double dividend = numbers.pop();
                    numbers.add(dividend / divisor);
                    break;
                case '*':
                    numbers.add(numbers.pop() * numbers.pop());
                    break;
                case '^':
                    double exponent = numbers.pop();
                    double base = numbers.pop();
                    numbers.add(Math.pow(base, exponent));
                    break;
                default:
                    numbers.push((double) Character.getNumericValue(postFix.charAt(i)));
            }
        }
        return numbers.pop();
    }
}

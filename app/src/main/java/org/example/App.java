package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println(Calculator.evaluate("2 + 5")); // Should print 7.0
        System.out.println(Calculator.evaluate("3 + 6 * 5")); // Should print 33.0
        System.out.println(Calculator.evaluate("4 * (2 + 3)")); // Should print 20.0
        System.out.println(Calculator.evaluate("(7 + 9) / 8")); // Should print 2.0
        System.out.println(Calculator.evaluate("5 - 3")); // Should print 2.0
        System.out.println(Calculator.evaluate("6 / 2")); // Should print 3.0
    }
}

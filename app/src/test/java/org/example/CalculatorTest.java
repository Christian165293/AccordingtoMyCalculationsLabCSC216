package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testEvaluateSimpleAddition() {
        assertEquals(7.0, Calculator.evaluate("2 + 5"), 0.001);
    }

    @Test
    void testEvaluateSimpleSubtraction() {
        assertEquals(3.0, Calculator.evaluate("5 - 2"), 0.001);
    }

    @Test
    void testEvaluateSimpleMultiplication() {
        assertEquals(10.0, Calculator.evaluate("2 * 5"), 0.001);
    }

    @Test
    void testEvaluateSimpleDivision() {
        assertEquals(2.5, Calculator.evaluate("5 / 2"), 0.001);
    }

    @Test
    void testEvaluateExponentiation() {
        assertEquals(8.0, Calculator.evaluate("2 ^ 3"), 0.001);
    }

    @Test
    void testEvaluateComplexExpression() {
        assertEquals(33.0, Calculator.evaluate("3 + 6 * 5"), 0.001);
    }

    @Test
    void testEvaluateExpressionWithParentheses() {
        assertEquals(20.0, Calculator.evaluate("4 * (2 + 3)"), 0.001);
    }

    @Test
    void testEvaluateExpressionWithNestedParentheses() {
        assertEquals(2.0, Calculator.evaluate("(7 + 9) / 8"), 0.001);
    }

    @Test
    void testEvaluateInvalidExpression() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.evaluate("2 + (3 * 4"));
    }
}
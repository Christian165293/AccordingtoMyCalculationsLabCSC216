package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShuntingYardAlgorithmTest {

    @Test
    void testInfixToPostfixSimpleAddition() {
        assertEquals("25+", ShuntingYardAlgorithm.infixToPostfix("2 + 5"));
    }

    @Test
    void testInfixToPostfixSimpleSubtraction() {
        assertEquals("52-", ShuntingYardAlgorithm.infixToPostfix("5 - 2"));
    }

    @Test
    void testInfixToPostfixSimpleMultiplication() {
        assertEquals("25*", ShuntingYardAlgorithm.infixToPostfix("2 * 5"));
    }

    @Test
    void testInfixToPostfixSimpleDivision() {
        assertEquals("52/", ShuntingYardAlgorithm.infixToPostfix("5 / 2"));
    }

    @Test
    void testInfixToPostfixExponentiation() {
        assertEquals("23^", ShuntingYardAlgorithm.infixToPostfix("2 ^ 3"));
    }

    @Test
    void testInfixToPostfixComplexExpression() {
        assertEquals("365*+", ShuntingYardAlgorithm.infixToPostfix("3 + 6 * 5"));
    }

    @Test
    void testInfixToPostfixExpressionWithParentheses() {
        assertEquals("423+*", ShuntingYardAlgorithm.infixToPostfix("4 * (2 + 3)"));
    }

    @Test
    void testInfixToPostfixExpressionWithNestedParentheses() {
        assertEquals("79+8/", ShuntingYardAlgorithm.infixToPostfix("(7 + 9) / 8"));
    }

    @Test
    void testInfixToPostfixInvalidExpression() {
        assertThrows(IllegalArgumentException.class, () -> ShuntingYardAlgorithm.infixToPostfix("2 + (3 * 4"));
    }
}
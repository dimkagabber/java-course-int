package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayHandlerTestNMaxGenericDouble {

    private ArrayHandlerGeneric arrayHandler;

    @BeforeEach
    void setUp() {
        arrayHandler = new ArrayHandlerGeneric();
    }

    @Test
    @DisplayName("basic scenario")
    void testGetMaxNBasicScenario() {
        Double[] input = {8., 7., 9., 2., 5., 4.};
        Double[] result = {9., 8., 7.};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("All elements negative")
    void testGetMaxNNegative() {
        Double[] input = {-9., -7., -8., -2., -5., -4.};
        Double[] result = {-2., -4., -5.};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("Some elements the same")
    void testGetMaxNIncludesSeveralDoublicatesOfOneValue() {
        Double[] input = {9., 8., 8., 10., 8., 4.};
        Double[] result = {10., 9., 8.};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("Various duplicate elements")
    void testGetMaxNIncludesSeveralDoublicatesOfSeveralValues() {
        Double[] input = {4., 4., 9., 9., 4., 8., 9., 8., 8., 10., 8., 4., 9.};
        Double[] result = {10., 9., 8.};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("The biggest element at the beginning")
    void testGetMaxNBiggestAtTheBeginning() {
        Double[] input = {11., 1., 3., 10., 8., 4.};
        Double[] result = {11., 10., 8.};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("The biggest element at the end")
    void testGetMaxNBiggestAtTheEnd() {
        Double[] input = {1., 3., 10., 8., 4., 11.};
        Double[] result = {11., 10., 8.};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("Not enough elements in the input array")
    void testGetMaxNNotEnoughElelementsInInput() {
        Double[] input = {1., 3., 10.};
        Double[] result = {10., 3., 1.};
        assertArrayEquals(result, arrayHandler.getMax(input, 5));
    }

    @Test
    @DisplayName("Not enough different elements in the input array")
    void testGetMaxNNotEnoughDifferentElelementsInInput() {
        Double[] input = {1., 1., 10., 2., 10., 1., 2.};
        Double[] result = {10., 2., 1.};
        assertArrayEquals(result, arrayHandler.getMax(input, 5));
    }

    @Test
    @DisplayName("Empty input")
    void testGetMaxNEmptyInput() {
        Double[] input = new Double[0];
        Double[] result = new Double[0];
        assertArrayEquals(result, arrayHandler.getMax(input, 5));
    }

    @Test
    @DisplayName("Null input")
    void testGetMaxNNullInput() {
        Double[] input = null;
        Double[] result = null;
        assertArrayEquals(result, arrayHandler.getMax(input, 5));
    }

    @Test
    @DisplayName("n is negative")
    void testGetMaxNNIsNegative() {
        Double[] input = {1., 2., 3., 4., 5.};
        final Exception ex = assertThrows(IllegalArgumentException.class,
                () -> {
                    arrayHandler.getMax(input, -5);
                });
        assertEquals("Parameter n must be >= 0", ex.getMessage());
    }

    @Test
    @DisplayName("n is 0")
    void testGetMaxNIsZero() {
        Double[] input = {1., 2., 3., 4., 5.};
        Double[] result = new Double[0];
        ;
        assertArrayEquals(result, arrayHandler.getMax(input, 0));
    }

    /*
    @Test
    @DisplayName("parseDoubles() only numbers")
    void testParseDoublesCorrect() {
        //entered data contains only numbers
        String[] args = {"1","2","3","4"};
        Double[]array = {1,2,3,4};
        assertArrayEquals(array, arrayHandler.parseDoubles(args));
    }

    @Test
    @DisplayName("parseDoubles() chars entered")
    void testParseDoublesEnteredChar() {
        //entered data contains chars
        String[] args = {"1","2","three","4"};
        final Exception ex = assertThrows(ArithmeticException.class,
                () -> {
                    arrayHandler.parseDoubles(args);
                });
        assertEquals("Not all entered values are doubles", ex.getMessage());
    }*/
}


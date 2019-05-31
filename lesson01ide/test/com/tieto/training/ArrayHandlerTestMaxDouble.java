package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerTestMaxDouble {

    private ArrayHandler arrayHandler;

    @BeforeEach
    void setUp() {
        arrayHandler = new ArrayHandler();
    }

    @Test
    @DisplayName("getMax() only positive")
    void testGetMaxPositive() {
        //only positive values
        double[] array = {1,2,3};
        assertEquals(3, arrayHandler.getMax(array));
    }

    @Test
    @DisplayName("getMax() only negative")
    void testGetMaxNegative() {
        //only negative values
        double[] array = {-1,-2,-3};
        assertEquals(-1,arrayHandler.getMax(array));
    }

    @Test
    @DisplayName("getMax() equals")
    void testGetMaxEquals() {
        //equal values
        double[] array = {3,3,3};
        assertEquals(3, arrayHandler.getMax(array));
    }

    @Test
    @DisplayName("getMax() max first")
    void testGetMaxMaxFirst() {
        double[] array = {3,0,-1};
        assertEquals(3,arrayHandler.getMax(array));
    }

    @Test
    @DisplayName("getMax() max last")
    void testGetMaxMaxLast() {
        //max value last
        double[] array = {0,-1,3};
        assertEquals(3, arrayHandler.getMax(array));
    }

    @Test
    @DisplayName("getMax() empty array")
    void testGetMaxEmpty() {
        //empty array
        double[] array = {};
        assertThrows(Error.class,
                () -> {
                    arrayHandler.getMax(array);
                });
    }

    @Test
    @DisplayName("parseDoubles() only numbers")
    void testParseDoublesCorrect() {
        //entered data contains only numbers
        String[] args = {"1","2","3","4"};
        double[] array = {1,2,3,4};
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
    }
}
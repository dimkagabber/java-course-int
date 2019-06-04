package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerMaxTest {
    private static final double DELTA = 0.0001;

    private ArrayHandler ah;

    @BeforeEach
    void init() {
        ah = new ArrayHandler();
    }

    @Test
    @DisplayName("getMax() common scenario")
    void getMax() {
        // 1. Set the test data
        final double[] input = {3.14, -15.7, 8.9, 10.47, -89.2, 9.999};
        final double expected = 10.47;
        // 2. Perform the tested operation
        final double actual = ah.getMax(input);
        // 3. Verify the result
        assertEquals(expected, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() all items the same")
    void getMaxAllTheSame() {
        final double[] input = {3.14, 3.14, 3.14, 3.14, 3.14, 3.14, 3.14, 3.14, 3.14, 3.14,};
        final double actual = ah.getMax(input);
        assertEquals(3.14, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() all items are negative")
    void getMaxAllNegative() {
        final double[] input = {-3.14, -3.14, -3.14, -3.14, -3.14, -3.14, -3.14, -3.14, -3.14, -3.14,};
        final double actual = ah.getMax(input);
        assertEquals(-3.14, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() max item is first")
    void getMaxFirstElement() {
        final double[] input = {999.0, 3.14, -15.7, 8.9, 10.47, -89.2, 9.999};
        final double actual = ah.getMax(input);
        assertEquals(999.0, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() max item is last")
    void getMaxLastElement() {
        final double[] input = {3.14, -15.7, 8.9, 10.47, -89.2, 9.999, 999.0};
        final double actual = ah.getMax(input);
        assertEquals(999.0, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() empty array should return NaN")
    void getMaxEmptyArray() {
        final double[] input = {};
        final double actual = ah.getMax(input);
        assertTrue(Double.isNaN(actual));
    }

    @Test
    @DisplayName("getMax() null array should return NaN")
    void getMaxNullArray() {
        final double[] input = null;
        final double actual = ah.getMax(input);
        assertTrue(Double.isNaN(actual));
    }
}
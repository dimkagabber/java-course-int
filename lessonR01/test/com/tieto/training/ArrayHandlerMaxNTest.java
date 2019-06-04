package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayHandlerMaxNTest {
    private static final double DELTA = 0.0001;
    private ArrayHandler ah;

    @BeforeEach
    void init() {
        ah = new ArrayHandler();
    }

    @Test
    @DisplayName("getMax() basic scenario")
    void getMax() {
        final double[] input = {3.14, -15.7, 8.9, 10.47, -89.2, 9.999, 40.8, 15.3, 8.6,};
        final double[] expected = {40.8, 15.3, 10.47};
        final double[] actual = ah.getMax(input, 3);
        assertArrayEquals(expected, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() ignore NaNs")
    void getMaxIgnoreNaNs() {
        final double[] input = {Double.NaN, 3.14, Double.NaN, 40.8, Double.NaN, };
        final double[] expected = {40.8, 3.14, };
        final double[] actual = ah.getMax(input, 3);
        assertArrayEquals(expected, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() duplicate elements")
    void getMaxDuplicateElements() {
        final double[] input = {17.8, 3.14, -15.7, 8.9, 10.47, -89.2, 15.3, 15.3, 9.999, 40.8, 40.8, 15.3, 8.6,};
        final double[] expected = {40.8, 17.8, 15.3};
        final double[] actual = ah.getMax(input, 3);
        assertArrayEquals(expected, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() not enough data")
    void getMaxNotEnoughData() {
        final double[] input = {3.14, -15.7, 3.14, -15.7, 3.14, -15.7, 3.14, -15.7, 3.14, -15.7, 3.14, -15.7, 3.14, -15.7, 3.14, -15.7,};
        final double[] expected = {3.14, -15.7,};
        final double[] actual = ah.getMax(input, 3);
        assertArrayEquals(expected, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() all elements negative")
    void getMaxAllNegative() {
        final double[] input = {-3.14, -15.7, -8.9, -10.47, -89.2, -9.999, -40.8, -15.3, -8.6,};
        final double[] expected = {-3.14, -8.6, -8.9};
        final double[] actual = ah.getMax(input, 3);
        assertArrayEquals(expected, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() empty array")
    void getMaxEmptyArray() {
        final double[] input = {};
        final double[] expected = {};
        final double[] actual = ah.getMax(input, 15);
        assertArrayEquals(expected, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() null input")
    void getMaxNullInput() {
        final double[] input = null;
        final double[] expected = {};
        final double[] actual = ah.getMax(input, 15);
        assertArrayEquals(expected, actual, DELTA);
    }

    @Test
    @DisplayName("getMax() negative n should throw exception")
    void getMaxNegativeN() {
        final double[] input = {3.14, -15.7, 8.9, 10.47, -89.2, 9.999, 40.8, 15.3, 8.6,};
        assertThrows(IllegalArgumentException.class, () -> ah.getMax(input, -3));
    }
}

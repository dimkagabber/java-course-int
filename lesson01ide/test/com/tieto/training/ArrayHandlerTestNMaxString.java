package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerTestNMaxString {


    private ArrayHandler arrayHandler;

    @BeforeEach
    void setUp() {
        arrayHandler = new ArrayHandler();
    }

    @Test
    @DisplayName("getMax(String[], int) basic scenario")
    void testGetMaxNBasicScenario() {
        String[] input = {"BA", "ABC", "CDE", "ACE"};
        String[] result = {"CDE", "BA", "ACE"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("getMax(String[], int) All or some elements are null")
    void testGetMaxNHasNullElements() {
        String[] input = {"BA", null, "CDE", null};
        String[] result = {"CDE", "BA"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("getMax(String[], int) Some elements the same")
    void testGetMaxNSameValueSeveralTimes() {
        String[] input = {"BA", "CDE", "BA", "DAB"};
        String[] result = {"DAB","CDE", "BA"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("getMax(String[], int) Various duplicate elements")
    void testGetMaxNSeveralValuesSeveralTimes() {
        String[] input = {"BA", "CDE", "CDE", "BA", "DAB"};
        String[] result = {"DAB", "CDE", "BA"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("getMax(String[], int) The biggest element at the beginning")
    void testGetMaxNBiggestAtTheBeginning() {
        String[] input = {"CDE", "BA", "ABC", "ACE"};
        String[] result = {"CDE", "BA", "ACE"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("getMax(String[], int) The biggest element at the beginning")
    void testGetMaxNBiggestAtTheEnd() {
        String[] input = {"ACE", "BA", "ABC", "CDE"};
        String[] result = {"CDE", "BA", "ACE"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("getMax(String[], int) Not enough elements in the input array")
    void testGetMaxNInputLessThanN() {
        String[] input = {"ACE", "BA", "ABC", "CDE"};
        String[] result = {"CDE", "BA", "ACE", "ABC"};
        assertArrayEquals(result, arrayHandler.getMax(input, 7));
    }

    @Test
    @DisplayName("getMax(String[], int) Not enough different elements in the input array")
    void testGetMaxNInputWithoutDuplicatesLessThanN() {
        String[] input = {"ACE", "BA", "ABC", "ABC"};
        String[] result = {"BA", "ACE", "ABC"};
        assertArrayEquals(result, arrayHandler.getMax(input, 4));
    }

    @Test
    @DisplayName("getMax(String[], int) Empty input")
    void testGetMaxNEmptyInput() {
        double[] input = {};
        double[] result = {};
        assertArrayEquals(result, arrayHandler.getMax(input, 5));
    }

    @Test
    @DisplayName("getMax(String[], int) Null array")
    void testGetMaxNNullInput() {
        String[] input = null;
        String[] result = {};
        assertArrayEquals(result, arrayHandler.getMax(input, 5));
    }

    @Test
    @DisplayName("getMax(String[], int) n is negative")
    void testGetMaxNNIsNegative() {
        String[] input = {"ACE", "BA", "ABC", "ABC"};
        final Exception ex = assertThrows(IllegalArgumentException.class,
                () -> {
                    arrayHandler.getMax(input, -5);
                });
        assertEquals("Parameter n must be >= 0", ex.getMessage());
    }

    @Test
    @DisplayName("getMax(String[], int) n is 0")
    void testGetMaxNIsZero() {
        String[] input = {"ACE", "BA", "ABC", "ABC"};
        String[] result = {};
        assertArrayEquals(result, arrayHandler.getMax(input, 0));
    }
}
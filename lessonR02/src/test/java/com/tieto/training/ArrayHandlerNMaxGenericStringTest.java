package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerNMaxGenericStringTest {

    private ArrayHandlerGeneric arrayHandler;
    private final StringComparatorEmptyHasPriority comparator = new StringComparatorEmptyHasPriority();

    @BeforeEach
    void setUp() {
        arrayHandler = new ArrayHandlerGeneric();
    }

    @Test
    @DisplayName("getMax(String[], int) basic scenario")
    void testGetMaxNBasicScenario() {
        String[] input = {"BA", "ABC", "CDE", "ACE"};
        String[] result = {"CDE", "BA", "ACE"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3, comparator));
    }

    @Test
    @DisplayName("getMax(String[], int) All or some elements are null")
    void testGetMaxNHasNullElements() {
        String[] input = {"BA", null, "CDE", null};
        String[] result = {"CDE", "BA"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3, comparator));
    }

    @Test
    @DisplayName("getMax(String[], int) Some elements the same")
    void testGetMaxNSameValueSeveralTimes() {
        String[] input = {"BA", "CDE", "BA", "DAB"};
        String[] result = {"DAB", "CDE", "BA"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3, comparator));
    }

    @Test
    @DisplayName("getMax(String[], int) Various duplicate elements")
    void testGetMaxNSeveralValuesSeveralTimes() {
        String[] input = {"BA", "CDE", "CDE", "BA", "DAB"};
        String[] result = {"DAB", "CDE", "BA"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3, comparator));
    }

    @Test
    @DisplayName("getMax(String[], int) The biggest element at the beginning")
    void testGetMaxNBiggestAtTheBeginning() {
        String[] input = {"CDE", "BA", "ABC", "ACE"};
        String[] result = {"CDE", "BA", "ACE"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3, comparator));
    }

    @Test
    @DisplayName("getMax(String[], int) The biggest element at the beginning")
    void testGetMaxNBiggestAtTheEnd() {
        String[] input = {"ACE", "BA", "ABC", "CDE"};
        String[] result = {"CDE", "BA", "ACE"};
        assertArrayEquals(result, arrayHandler.getMax(input, 3, comparator));
    }

    @Test
    @DisplayName("getMax(String[], int) Not enough elements in the input array")
    void testGetMaxNInputLessThanN() {
        String[] input = {"ACE", "BA", "ABC", "CDE"};
        String[] result = {"CDE", "BA", "ACE", "ABC"};
        assertArrayEquals(result, arrayHandler.getMax(input, 7, comparator));
    }

    @Test
    @DisplayName("getMax(String[], int) Not enough different elements in the input array")
    void testGetMaxNInputWithoutDuplicatesLessThanN() {
        String[] input = {"ACE", "BA", "ABC", "ABC"};
        String[] result = {"BA", "ACE", "ABC"};
        assertArrayEquals(result, arrayHandler.getMax(input, 4, comparator));
    }

    @Test
    @DisplayName("getMax(String[], int) Empty input")
    void testGetMaxNEmptyInput() {
        String[] input = {};
        String[] result = {};
        assertArrayEquals(result, arrayHandler.getMax(input, 5, comparator));
    }

    @Test
    @DisplayName("getMax(String[], int) Null array")
    void testGetMaxNNullInput() {
        String[] input = null;
        String[] result = null;
        assertArrayEquals(result, arrayHandler.getMax(input, 5, comparator));
    }


    @Test
    @DisplayName("getMax(String[], int) n is negative")
    void testGetMaxNNIsNegative() {
        String[] input = {"ACE", "BA", "ABC", "ABC"};
        final Exception ex = assertThrows(IllegalArgumentException.class,
                () -> {
                    arrayHandler.getMax(input, -5, comparator);
                });
        assertEquals("Parameter n must be >= 0", ex.getMessage());
    }

    @Test
    @DisplayName("getMax(String[], int) n is 0")
    void testGetMaxNIsZero() {
        String[] input = {"ACE", "BA", "ABC", "ABC"};
        String[] result = {};
        assertArrayEquals(result, arrayHandler.getMax(input, 0, comparator));
    }
}
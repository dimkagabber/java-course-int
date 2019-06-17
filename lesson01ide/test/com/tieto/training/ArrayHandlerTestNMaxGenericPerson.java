package com.tieto.training;

import com.tieto.training.person.Person;
import com.tieto.training.person.PersonComparatorNameOnly;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tieto.training.ArrayHandlerTestPersonValues.PERSONS;
import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerTestNMaxGenericPerson {

    private ArrayHandlerGeneric arrayHandler;
    private PersonComparatorNameOnly comparator;

    @BeforeEach
    void init() {
        arrayHandler = new ArrayHandlerGeneric();
        comparator = new PersonComparatorNameOnly();
    }

    @Test
    @DisplayName("basic scenario")
    void getMax() {
        Person[] input = {PERSONS[4], PERSONS[2], PERSONS[5], PERSONS[0], PERSONS[3], PERSONS[1]};
        Person[] expected = {PERSONS[0], PERSONS[1], PERSONS[2], PERSONS[3]};
        Object[] actual = arrayHandler.getMax(input, 4, comparator);
        //assertArrayEquals(expected, actual);
        //System.out.println("expected.getClass() = " + expected.getClass());
        //System.out.println("actual.getClass() = " + actual.getClass());
    }

    @Test
    @DisplayName("basic scenario, the first element is the biggest")
    void getMaxMaxFirst() {
        Person[] input = {PERSONS[0], PERSONS[2], PERSONS[5], PERSONS[4], PERSONS[3], PERSONS[1]};
        Person[] expected = {PERSONS[0], PERSONS[1], PERSONS[2], PERSONS[3]};
        assertArrayEquals(expected, arrayHandler.getMax(input, 4, comparator));
    }

    @Test
    @DisplayName("basic scenario, the last element is the biggest")
    void getMaxMaxLast() {
        Person[] input = {PERSONS[1], PERSONS[2], PERSONS[5], PERSONS[4], PERSONS[3], PERSONS[0]};
        Person[] expected = {PERSONS[0], PERSONS[1], PERSONS[2], PERSONS[3]};
        assertArrayEquals(expected, arrayHandler.getMax(input, 4, comparator));
    }

    @Test
    @DisplayName("has nulls")
    void getMaxHasNulls() {
        Person[] input = {PERSONS[4], null, PERSONS[5], null, PERSONS[3], PERSONS[1]};
        Person[] expected = {PERSONS[1], PERSONS[3], PERSONS[4]};
        assertArrayEquals(expected, arrayHandler.getMax(input, 3, comparator));
    }

    @Test
    @DisplayName("has equals")
    void getMaxHasDuplicates() {
        Person[] input = {PERSONS[4], PERSONS[1], PERSONS[5], PERSONS[0], PERSONS[5], PERSONS[1], PERSONS[4], PERSONS[2], PERSONS[3]};
        Person[] expected = {PERSONS[0], PERSONS[1], PERSONS[2], PERSONS[3]};
        assertArrayEquals(expected, arrayHandler.getMax(input, 4, comparator));
    }

    @Test
    @DisplayName("Not enough elements in the input array")
    void getMaxNotEnoughElementsInInput() {
        Person[] input = {PERSONS[3], PERSONS[1], PERSONS[2], PERSONS[0]};
        Person[] expected = {PERSONS[0], PERSONS[1], PERSONS[2], PERSONS[3]};
        assertArrayEquals(expected, arrayHandler.getMax(input, 9, comparator));
    }

    @Test
    @DisplayName("Not enough different elements in the input array")
    void getMaxNotEnoughDifferentElementsInInput() {
        Person[] input = {PERSONS[1], PERSONS[1], PERSONS[2], PERSONS[0], PERSONS[2]};
        Person[] expected = {PERSONS[0], PERSONS[1], PERSONS[2]};
        assertArrayEquals(expected, arrayHandler.getMax(input, 4, comparator));
    }

    @Test
    @DisplayName("Empty array")
    void getMaxEmptyArray() {
        Person[] input = new Person[0];
        Person[] result = new Person[0];
        assertArrayEquals(result, arrayHandler.getMax(input, 4, comparator));
    }

    @Test
    @DisplayName("Null array")
    void getMaxNullArray() {
        Person[] input = new Person[5];
        Person[] result = new Person[0];
        assertArrayEquals(result, arrayHandler.getMax(input, 4, comparator));
    }

    @Test
    @DisplayName("n is negative")
    void getMaxNIsNegative() {
        Person[] input = {PERSONS[4], PERSONS[2], PERSONS[5], PERSONS[0], PERSONS[3], PERSONS[1]};
        final Exception ex = assertThrows(IllegalArgumentException.class,
                () -> {
                    arrayHandler.getMax(input, -1, comparator);
                });
        assertEquals(ex.getMessage(), "Parameter n must be >= 0");
    }

    @Test
    @DisplayName("n is 0")
    void getMaxNIsZero() {
        Person[] input = {PERSONS[4], PERSONS[2], PERSONS[5], PERSONS[0], PERSONS[3], PERSONS[1]};
        Person[] result = new Person[0];
        assertArrayEquals(result, arrayHandler.getMax(input, 0, comparator));
    }
}
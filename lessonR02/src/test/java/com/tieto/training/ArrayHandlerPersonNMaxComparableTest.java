package com.tieto.training;

import com.tieto.training.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tieto.training.ArrayHandlerPersonValuesTest.PERSONS;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayHandlerPersonNMaxComparableTest {

    ArrayHandlerWithComparable arrayHandler;

    @BeforeEach
    void init() {
        arrayHandler = new ArrayHandlerWithComparable();
    }

    @Test
    @DisplayName("basic scenario")
    void getMax() {
        Person[] input = {PERSONS[4], PERSONS[2], PERSONS[5], PERSONS[0], PERSONS[3], PERSONS[1]};
        Person[] expected = {PERSONS[0], PERSONS[1], PERSONS[2], PERSONS[3]};
        assertArrayEquals(expected, arrayHandler.getMax(input, 4));
    }

    @Test
    @DisplayName("has nulls")
    void getMaxHasNulls() {
        Person[] input = {PERSONS[4], null, PERSONS[5], null, PERSONS[3], PERSONS[1]};
        Person[] expected = {PERSONS[1], PERSONS[3], PERSONS[4]};
        assertArrayEquals(expected, arrayHandler.getMax(input, 3));
    }

    @Test
    @DisplayName("has equals")
    void getMaxHasDuplicates() {
        Person[] input = {PERSONS[4], PERSONS[1], PERSONS[5], PERSONS[0], PERSONS[5], PERSONS[1], PERSONS[4], PERSONS[2], PERSONS[3]};
        Person[] expected = {PERSONS[0], PERSONS[1], PERSONS[2], PERSONS[3]};
        assertArrayEquals(expected, arrayHandler.getMax(input, 4));
    }

}
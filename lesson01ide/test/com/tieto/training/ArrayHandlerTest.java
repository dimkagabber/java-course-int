package com.tieto.training;

import com.tieto.training.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerTest {

    ArrayHandler arrayHandler;
    List<Person> PERSONS = Arrays.asList(ArrayHandlerTestPersonValues.PERSONS);
    List<Person> input;
    List<Person> result;

    @BeforeEach
    void setUp() {
        arrayHandler = new ArrayHandler();
        input = new ArrayList<Person>();
        result = new ArrayList<Person>();
    }

    @Test
    @DisplayName("basic scenario")
    void getMaxBasic() {
        input.add(PERSONS.get(0));
        input.add(PERSONS.get(2));
        input.add(PERSONS.get(3));
        input.add(PERSONS.get(4));
        input.add(PERSONS.get(1));
        input.add(PERSONS.get(5));

        result = PERSONS;

        assertEquals(result, arrayHandler.getMax(input,6));
    }

    @Test
    @DisplayName("has nulls")
    void getMaxHasNulls() {
        input.add(null);
        input.add(PERSONS.get(5));
        input.add(PERSONS.get(3));
        input.add(PERSONS.get(4));
        input.add(null);
        input.add(PERSONS.get(2));

        result.add(PERSONS.get(2));
        result.add(PERSONS.get(3));
        result.add(PERSONS.get(4));

        assertEquals(result, arrayHandler.getMax(input,3));
    }

    @Test
    @DisplayName("has all nulls")
    void getMaxAllNulls() {
        input.add(null);
        input.add(null);
        input.add(null);
        input.add(null);
        input.add(null);
        input.add(null);

        assertEquals(result, arrayHandler.getMax(input,3));
    }

    @Test
    @DisplayName("has duplicates")
    void getMaxHasDuplicates() {
        input.add(PERSONS.get(4));
        input.add(PERSONS.get(5));
        input.add(PERSONS.get(3));
        input.add(PERSONS.get(4));
        input.add(PERSONS.get(5));
        input.add(PERSONS.get(2));

        result.add(PERSONS.get(2));
        result.add(PERSONS.get(3));
        result.add(PERSONS.get(4));

        assertEquals(result, arrayHandler.getMax(input,3));
    }

    @Test
    @DisplayName("not enough elements")
    void getMaxNotEnoughElements() {
        input.add(PERSONS.get(5));
        input.add(PERSONS.get(3));
        input.add(PERSONS.get(4));
        input.add(PERSONS.get(2));

        result.add(PERSONS.get(2));
        result.add(PERSONS.get(3));
        result.add(PERSONS.get(4));
        result.add(PERSONS.get(5));

        assertEquals(result, arrayHandler.getMax(input,7));
    }

    @Test
    @DisplayName("not enough unique elements")
    void getMaxNotEnoughUniqueElements() {
        input.add(PERSONS.get(5));
        input.add(PERSONS.get(5));
        input.add(PERSONS.get(3));
        input.add(PERSONS.get(4));
        input.add(PERSONS.get(2));
        input.add(PERSONS.get(2));

        result.add(PERSONS.get(2));
        result.add(PERSONS.get(3));
        result.add(PERSONS.get(4));
        result.add(PERSONS.get(5));

        assertEquals(result, arrayHandler.getMax(input,5));
    }

    @Test
    @DisplayName("empty input")
    void getMaxEmpty() {
        input = new ArrayList<Person>();
        result = new ArrayList<Person>();

        assertEquals(result, arrayHandler.getMax(input,3));
    }

}
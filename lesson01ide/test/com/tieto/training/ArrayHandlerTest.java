package com.tieto.training;

import com.tieto.training.person.Person;
import com.tieto.training.person.PersonComparatorNameOnly;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class ArrayHandlerTest {

    ArrayHandler arrayHandler;
    List<Person> PERSONS = Arrays.asList(ArrayHandlerTestPersonValues.PERSONS);
    List<Person> input;
    List<Person> result;
    final Comparator<Person> comparator = new PersonComparatorNameOnly();

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

    @Test
    @DisplayName("basic scenario: comparator")
    void getMaxBasicComparator() {
        input.add(PERSONS.get(0));
        input.add(PERSONS.get(2));
        input.add(PERSONS.get(3));
        input.add(PERSONS.get(4));
        input.add(PERSONS.get(1));
        input.add(PERSONS.get(5));

        result = PERSONS;

        assertEquals(result, arrayHandler.getMax(input,6, comparator));
    }

    @Test
    @DisplayName("has nulls: comparator")
    void getMaxHasNullsComparator() {
        input.add(null);
        input.add(PERSONS.get(5));
        input.add(PERSONS.get(3));
        input.add(PERSONS.get(4));
        input.add(null);
        input.add(PERSONS.get(2));

        result.add(PERSONS.get(2));
        result.add(PERSONS.get(3));
        result.add(PERSONS.get(4));

        assertEquals(result, arrayHandler.getMax(input,3, comparator));
    }

    @Test
    @DisplayName("has all nulls: comparator")
    void getMaxAllNullsComparator() {
        input.add(null);
        input.add(null);
        input.add(null);
        input.add(null);
        input.add(null);
        input.add(null);

        assertEquals(result, arrayHandler.getMax(input,3, comparator));
    }

    @Test
    @DisplayName("has duplicates: comparator")
    void getMaxHasDuplicatesComparator() {
        input.add(PERSONS.get(4));
        input.add(PERSONS.get(5));
        input.add(PERSONS.get(3));
        input.add(PERSONS.get(4));
        input.add(PERSONS.get(5));
        input.add(PERSONS.get(2));

        result.add(PERSONS.get(2));
        result.add(PERSONS.get(3));
        result.add(PERSONS.get(4));

        assertEquals(result, arrayHandler.getMax(input,3, comparator));
    }

    @Test
    @DisplayName("not enough elements: comparator")
    void getMaxNotEnoughElementsComparator() {
        input.add(PERSONS.get(5));
        input.add(PERSONS.get(3));
        input.add(PERSONS.get(4));
        input.add(PERSONS.get(2));

        result.add(PERSONS.get(2));
        result.add(PERSONS.get(3));
        result.add(PERSONS.get(4));
        result.add(PERSONS.get(5));

        assertEquals(result, arrayHandler.getMax(input,7, comparator));
    }

    @Test
    @DisplayName("not enough unique elements: comparator")
    void getMaxNotEnoughUniqueElementsComparator() {
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

        assertEquals(result, arrayHandler.getMax(input,5, comparator));
    }

    @Test
    @DisplayName("empty input: comparator")
    void getMaxEmptyComparator() {
        input = new ArrayList<Person>();
        result = new ArrayList<Person>();

        assertEquals(result, arrayHandler.getMax(input,3, comparator));
    }


}
package com.tieto.training;

import com.tieto.training.person.Person;
import com.tieto.training.person.PersonComparatorNameOnly;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.tieto.training.ArrayHandlerTestPersonValues.PERSONS;

class ArrayHandlerTestPersonCompareComparator {

    private PersonComparatorNameOnly comparator;

    @BeforeEach
    void init() {
        comparator = new PersonComparatorNameOnly();
    }

    @Test
    @DisplayName("any to any")
    void compareElements() {
        for (int i = 0; i < PERSONS.length; i++) {
            for (int j = i + 1; j < PERSONS.length - 1; j++) {
                assertTrue(comparator.compare(PERSONS[i], PERSONS[j + 1]) > 0, "expected p[" + i + "] bigger than p[" + (j + 1) + "]");
                assertTrue(comparator.compare(PERSONS[j], PERSONS[i]) < 0, "expected p[" + j + "] smaller than p[" + i + "]");
            }
        }
    }

    @Test
    @DisplayName("equal elements")
    void compareElementsSomeEquial() {
        for (int i = 0; i < PERSONS.length; i++) {
            assertEquals(0, comparator.compare(PERSONS[i], PERSONS[i]), "expected p[" + i + "] equal to p[" + i + "]");
        }
    }

}
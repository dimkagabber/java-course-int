package com.tieto.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.tieto.training.ArrayHandlerPersonValuesTest.PERSONS;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayHandlerPersonCompareComparableTest {


    @Test
    @DisplayName("basic scenario")
    void compareElements() {
        for (int i = 0; i < PERSONS.length; i++) {
            for (int j = i+1; j < PERSONS.length-1; j++) {
                assertTrue(PERSONS[i].compareTo(PERSONS[j+1]) > 0, "expected p["+i+"] bigger than p["+(j+1)+"]");
                assertTrue(PERSONS[j].compareTo(PERSONS[i]) < 0,"expected p["+j+"] smaller than p["+i+"]");
            }
        }
    }

    @Test
    @DisplayName("equal elements")
    void compareElementsSomeEquial() {
        for (int i = 0; i < PERSONS.length; i++) {
            assertTrue(PERSONS[i].compareTo(PERSONS[i]) == 0, "expected p["+i+"] equal to p["+i+"]");
        }
    }

    }
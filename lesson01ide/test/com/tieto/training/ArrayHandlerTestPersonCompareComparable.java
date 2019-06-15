package com.tieto.training;

import com.tieto.training.person.Person;
import com.tieto.training.person.PersonComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayHandlerTestPersonCompareComparable {

    //test data
    final Person PERSONS[] = {
            Person.builder()
                    .lastName("")
                    .firstName("Michael")
                    .build(),
            Person.builder()
                    .lastName("Scott")
                    .firstName("Michael")
                    .build(),
            Person.builder()
                    .lastName("Scott")
                    .firstName("John")
                    .build(),
            Person.builder()
                    .lastName("Schrute")
                    .firstName("")
                    .build(),
            Person.builder()
                    .lastName("Howard")
                    .firstName(null)
                    .build(),
            Person.builder()
                    .lastName("Halpert")
                    .firstName("Jim")
                    .build()
    };
    //tests

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
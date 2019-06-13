package com.tieto.training;

import com.tieto.training.person.Address;
import com.tieto.training.person.Gender;
import com.tieto.training.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerTestPersonCompare {

    ArrayHandler arrayHandler;

    final static int FIRST_BIGGER = 1;
    final static int EQUAL = 0;
    final static int SECOND_BIGGER = -1;

    //test data
    final Person PERSONS[] = {
            /*Person.builder()
                    .lastName(null)
                    .firstName(null)
                    .build(),
            Person.builder()
                    .lastName(null)
                    .firstName("Pam")
                    .build(),*/
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

    @BeforeEach
    void init() {
        arrayHandler = new ArrayHandler();
    }

    @Test
    @DisplayName("basic scenario")
    void compareElements() {
        for (int i = 0; i < PERSONS.length; i++) {
            for (int j = i+1; j < PERSONS.length-1; j++) {
                assertTrue(arrayHandler.compareElements(PERSONS[i],PERSONS[j+1]) == FIRST_BIGGER, "expected p["+i+"] bigger than p["+(j+1)+"]");
                assertTrue(arrayHandler.compareElements(PERSONS[j],PERSONS[i]) == SECOND_BIGGER,"expected p["+j+"] smaller than p["+i+"]");
            }
        }
    }

    @Test
    @DisplayName("equal elements")
    void compareElementsSomeEquial() {
        for (int i = 0; i < PERSONS.length; i++) {
            assertTrue(arrayHandler.compareElements(PERSONS[i],PERSONS[i]) == EQUAL, "expected p["+i+"] equal to p["+i+"]");
        }
    }

    }
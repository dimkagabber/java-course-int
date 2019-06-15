package com.tieto.training;

import com.tieto.training.person.Address;
import com.tieto.training.person.Gender;
import com.tieto.training.person.Person;
import com.tieto.training.person.PersonComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerTestPersonCompareComparator {

    PersonComparator comparator;

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
        comparator = new PersonComparator();
    }

    @Test
    @DisplayName("basic scenario")
    void compareElements() {
        System.out.println(comparator.compare(PERSONS[1],PERSONS[3]));
        for (int i = 0; i < PERSONS.length; i++) {
            for (int j = i+1; j < PERSONS.length-1; j++) {
                assertTrue(comparator.compare(PERSONS[i],PERSONS[j+1]) > 0, "expected p["+i+"] bigger than p["+(j+1)+"]");
                assertTrue(comparator.compare(PERSONS[j],PERSONS[i]) < 0,"expected p["+j+"] smaller than p["+i+"]");
            }
        }
    }

    @Test
    @DisplayName("equal elements")
    void compareElementsSomeEquial() {
        for (int i = 0; i < PERSONS.length; i++) {
            assertTrue(comparator.compare(PERSONS[i],PERSONS[i]) == 0, "expected p["+i+"] equal to p["+i+"]");
        }
    }

    }
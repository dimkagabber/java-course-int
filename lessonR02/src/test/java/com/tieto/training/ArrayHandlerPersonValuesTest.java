package com.tieto.training;

import com.tieto.training.person.Person;

public class ArrayHandlerPersonValuesTest {
    public final static Person[] PERSONS = {
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
}

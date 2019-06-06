package com.tieto.training;

import com.tieto.training.person.Address;
import com.tieto.training.person.Gender;
import com.tieto.training.person.Person;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerTestNMaxPerson {

    ArrayHandler arrayHandler;

    @BeforeEach
    void setUp() {
        arrayHandler = new ArrayHandler();
    }

    @Test
    @DisplayName("Basic scenario")
    void getMaxBasic() {
        Person[] input = new Person[5];
        input[0] = Person.builder()
            .firstName("Michael")
            .lastName("Scott")
            .gender(Gender.MAN)
            .highSkilled(true)
            .address(
                    Address.builder()
                    .city("Scranton")
                    .street("Duncan st")
                    .build())
            .build();

        input[1] = Person.builder()
                .firstName("Dwight")
                .lastName("Schrute")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Bear Creek")
                                .street("Schrute's farm")
                                .build())
                .build();

        input[2] = Person.builder()
                .firstName("Jim")
                .lastName("Halpert")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("Orchard st")
                                .build())
                .build();

        input[3] = Person.builder()
                .firstName("Pam")
                .lastName("Beesly")
                .gender(Gender.WOMAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("River st")
                                .build())
                .build();

        input[4] = Person.builder()
                .firstName("Ryan")
                .lastName("Howard")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("New York")
                                .street("1st ave")
                                .build())
                .build();

        Person[] result = new Person[5];

        result[0] = Person.builder()
                .firstName("Pam")
                .lastName("Beesly")
                .gender(Gender.WOMAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("River st")
                                .build())
                .build();

        result[1] = Person.builder()
                .firstName("Jim")
                .lastName("Halpert")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("Orchard st")
                                .build())
                .build();

        result[2] = Person.builder()
                .firstName("Ryan")
                .lastName("Howard")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("New York")
                                .street("1st ave")
                                .build())
                .build();

        result[3] = Person.builder()
                .firstName("Dwight")
                .lastName("Schrute")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Bear Creek")
                                .street("Schrute's farm")
                                .build())
                .build();

        result[4] = Person.builder()
                .firstName("Michael")
                .lastName("Scott")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("Duncan st")
                                .build())
                .build();

        assertEquals(result, arrayHandler.getMax(input,4));

    }

    @Test
    @DisplayName("Some persons have empty first name and/or last name")
    void getMaxEmptyName() {
        Person[] input = new Person[5];
        input[0] = Person.builder()
                .firstName("Michael")
                .lastName("Scott")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("Duncan st")
                                .build())
                .build();

        input[1] = Person.builder()
                .firstName("Dwight")
                .lastName("")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Bear Creek")
                                .street("Schrute's farm")
                                .build())
                .build();

        input[2] = Person.builder()
                .firstName("")
                .lastName("Halpert")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("Orchard st")
                                .build())
                .build();

        input[3] = Person.builder()
                .firstName("Pam")
                .lastName("Beesly")
                .gender(Gender.WOMAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("River st")
                                .build())
                .build();

        input[4] = Person.builder()
                .firstName("Ryan")
                .lastName("")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("New York")
                                .street("1st ave")
                                .build())
                .build();

        Person[] result = new Person[5];

        input[0] = Person.builder()
                .firstName("Dwight")
                .lastName("")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Bear Creek")
                                .street("Schrute's farm")
                                .build())
                .build();

        input[1] = Person.builder()
                .firstName("Ryan")
                .lastName("")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("New York")
                                .street("1st ave")
                                .build())
                .build();

        input[2] = Person.builder()
                .firstName("Pam")
                .lastName("Beesly")
                .gender(Gender.WOMAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("River st")
                                .build())
                .build();

        input[3] = Person.builder()
                .firstName("Michael")
                .lastName("Scott")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("Duncan st")
                                .build())
                .build();

        assertEquals(result, arrayHandler.getMax(input,4));
    }

    @Test
    @DisplayName("All or some elements are null")
    void getMaxNullElements() {
    }

    @Test
    @DisplayName("Some elements the same")
    void getMaxOneDuplicateElement() {
    }

    @Test
    @DisplayName("The biggest element at the beginning")
    void getMaxBiggestFirst() {
    }

    @Test
    @DisplayName("The biggest element at the end")
    void getMaxBiggestLast() {
    }

    @Test
    @DisplayName("Various duplicate elements")
    void getMaxSeveralDuplicateElements() {
    }

    @Test
    @DisplayName("Not enough elements in the input array")
    void getMaxNotEnoughElementsInInput () {
    }

    @Test
    @DisplayName("Not enough different elements in the input array")
    void getMaxNotEnoughDifferentElementsInInput () {
    }

    @Test
    @DisplayName("Empty array")
    void getMaxEmptyArray() {
    }

    @Test
    @DisplayName("Null array")
    void getMaxNullArray() {
    }

    @Test
    @DisplayName("n is negative")
    void getMaxNIsNegative() {
    }

    @Test
    @DisplayName("n is 0")
    void getMaxNIsZero() {
    }

}
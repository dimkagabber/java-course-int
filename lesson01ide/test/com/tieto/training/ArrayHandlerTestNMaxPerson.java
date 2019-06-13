package com.tieto.training;

import com.tieto.training.person.Address;
import com.tieto.training.person.Gender;
import com.tieto.training.person.Person;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
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
        input[1] = Person.builder()
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

        input[0] = Person.builder()
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

        Person[] resultExpected = new Person[4];

        resultExpected[0] = Person.builder()
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

        resultExpected[1] = Person.builder()
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

        resultExpected[3] = Person.builder()
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

        resultExpected[2] = Person.builder()
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

        assertArrayEquals(resultExpected, arrayHandler.getMax(input, 4));
    }

    @Test
    @DisplayName("Some persons have empty first name and/or last name")
    void getMaxEmptyName() {

        Person[] p1 = new Person[1];
        p1[0] = Person.builder()
                .firstName("Michael")
                .lastName("")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("Duncan st")
                                .build())
                .build();
        Person[] p2 = new Person[1];
        p2[0] = Person.builder()
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

         Person[] input = new Person[5];
        input[0] = Person.builder()
                .firstName("Michael")
                .lastName("")
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
                .lastName("")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("Orchard st")
                                .build())
                .build();

        input[3] = Person.builder()
                .firstName("")
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

        Person[] result = new Person[4];

        result[0] = Person.builder()
                .firstName("Michael")
                .lastName("")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("Duncan st")
                                .build())
                .build();

        result[2] = Person.builder()
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

        result[1] = Person.builder()
                .firstName("Jim")
                .lastName("")
                .gender(Gender.MAN)
                .highSkilled(true)
                .address(
                        Address.builder()
                                .city("Scranton")
                                .street("Orchard st")
                                .build())
                .build();

        result[3] = Person.builder()
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

        assertArrayEquals(result, arrayHandler.getMax(input, 4));

    }

    @Test
    @DisplayName("All or some elements are null")
    void getMaxNullElements() {
        Person[] input = new Person[5];

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

        Person[] result = new Person[2];

        result[0] = Person.builder()
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

        assertArrayEquals(result, arrayHandler.getMax(input, 2));

    }

    @Test
    @DisplayName("Some elements the same")
    void getMaxOneDuplicateElement() {
        Person[] input = new Person[7];
        input[0] = Person.builder()
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

        input[1] = Person.builder()
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

        input[2] = Person.builder()
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

        input[3] = Person.builder()
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

        input[4] = Person.builder()
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

        input[5] = Person.builder()
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

        input[6] = Person.builder()
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

        Person[] result = new Person[4];

        result[0] = Person.builder()
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

        result[1] = Person.builder()
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

        result[3] = Person.builder()
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

        assertArrayEquals(result, arrayHandler.getMax(input, 4));

    }

    @Test
    @DisplayName("The biggest element at the beginning")
    void getMaxBiggestFirst() {
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

        Person[] result = new Person[4];

        result[0] = Person.builder()
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

        result[1] = Person.builder()
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

        result[3] = Person.builder()
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

        assertArrayEquals(result, arrayHandler.getMax(input, 4));

    }

    //
    @Test
    @DisplayName("The biggest element at the end")
    void getMaxBiggestLast() {
        Person[] input = new Person[5];
        input[4] = Person.builder()
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

        input[0] = Person.builder()
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

        Person[] result = new Person[4];

        result[0] = Person.builder()
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

        result[1] = Person.builder()
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

        result[3] = Person.builder()
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

        assertArrayEquals(result, arrayHandler.getMax(input, 4));

    }

    @Test
    @DisplayName("Various duplicate elements")
    void getMaxSeveralDuplicateElements() {
        Person[] input = new Person[9];
        input[0] = Person.builder()
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

        input[1] = Person.builder()
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

        input[2] = Person.builder()
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

        input[3] = Person.builder()
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

        input[4] = Person.builder()
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

        input[5] = Person.builder()
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

        input[6] = Person.builder()
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

        input[7] = Person.builder()
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

        input[8] = Person.builder()
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

        Person[] result = new Person[4];

        result[0] = Person.builder()
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

        result[1] = Person.builder()
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

        result[3] = Person.builder()
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

        assertArrayEquals(result, arrayHandler.getMax(input, 4));

    }

    @Test
    @DisplayName("Not enough elements in the input array")
    void getMaxNotEnoughElementsInInput() {
        Person[] input = new Person[5];
        input[1] = Person.builder()
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

        input[0] = Person.builder()
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

        result[1] = Person.builder()
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

        result[3] = Person.builder()
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

        result[4] = Person.builder()
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
        assertArrayEquals(result, arrayHandler.getMax(input, 8));

    }

    @Test
    @DisplayName("Not enough different elements in the input array")
    void getMaxNotEnoughDifferentElementsInInput() {
        Person[] input = new Person[9];
        input[0] = Person.builder()
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

        input[1] = Person.builder()
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

        input[2] = Person.builder()
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

        input[3] = Person.builder()
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

        input[4] = Person.builder()
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

        input[5] = Person.builder()
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

        input[6] = Person.builder()
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

        input[7] = Person.builder()
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

        input[8] = Person.builder()
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

        Person[] result = new Person[5];

        result[0] = Person.builder()
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

        result[1] = Person.builder()
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

        result[3] = Person.builder()
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

        result[4] = Person.builder()
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

        assertArrayEquals(result, arrayHandler.getMax(input, 7));

    }

    @Test
    @DisplayName("Empty array")
    void getMaxEmptyArray() {
        Person[] input = new Person[0];
        Person[] result = new Person[1];

        result = new Person[0];

        assertArrayEquals(result, arrayHandler.getMax(input, 4));
    }

    @Test
    @DisplayName("Null array")
    void getMaxNullArray() {
        Person[] input = new Person[5];
        Person[] result = new Person[1];

        result = new Person[0];

        assertArrayEquals(result, arrayHandler.getMax(input, 4));
    }

    @Test
    @DisplayName("n is negative")
    void getMaxNIsNegative() {
        Person[] input = new Person[5];
        input[1] = Person.builder()
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

        input[0] = Person.builder()
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

        Person[] result = new Person[4];

        final Exception ex = assertThrows(IllegalArgumentException.class,
                () -> {
                    arrayHandler.getMax(input, -1);
                });

        assertEquals(ex.getMessage(), "Parameter n must be >= 0");
    }

    @Test
    @DisplayName("n is 0")
    void getMaxNIsZero() {
        Person[] input = new Person[5];
        input[1] = Person.builder()
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

        input[0] = Person.builder()
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

        Person[] result = new Person[0];

        assertArrayEquals(result, arrayHandler.getMax(input, 0));

    }

}
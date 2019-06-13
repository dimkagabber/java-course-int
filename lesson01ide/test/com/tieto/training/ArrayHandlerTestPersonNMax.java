package com.tieto.training;

import com.tieto.training.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHandlerTestPersonNMax {

    ArrayHandler arrayHandler;

    //test data
    final Person P0 = Person.builder()
            .lastName("Scott")
            .firstName("Michael")
            .build();
    final Person P1 = Person.builder()
            .lastName("Scott")
            .firstName("John")
            .build();
    final Person P2 = Person.builder()
            .lastName("Schrute")
            .firstName("Dwight")
            .build();
    final Person P3 = Person.builder()
            .lastName("Howard")
            .firstName(null)
            .build();
    final Person P4 = Person.builder()
            .lastName("Halpert")
            .firstName("Jim")
            .build();
    final Person P5 = Person.builder()
            .lastName("Beesly")
            .firstName("Pam")
            .build();


    @BeforeEach
    void init(){
        arrayHandler = new ArrayHandler();
    }

@Test
@DisplayName("basic scenario")
    void getMax(){
        Person[] input = {P4,P2,P5,P0,P3,P1};
        Person[] expected = {P0,P1,P2,P3};
        assertArrayEquals(expected,arrayHandler.getMax(input,4));
            }

    @Test
    @DisplayName("has nulls")
    void getMaxHasNulls(){
        Person[] input = {P4,null,P5,null,P3,P1};
        Person[] expected = {P1,P3,P4};
        assertArrayEquals(expected,arrayHandler.getMax(input,3));
    }

    @Test
    @DisplayName("has equals")
    void getMaxHasDuplicates(){
        Person[] input = {P4,P1,P5,P0,P5,P1,P4,P2,P3};
        Person[] expected = {P0,P1,P2,P3};
        assertArrayEquals(expected,arrayHandler.getMax(input,4));
    }

}
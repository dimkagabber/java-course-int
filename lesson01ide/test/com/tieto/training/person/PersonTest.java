package com.tieto.training.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    final private Person P1 =
            Person.builder()
                    .lastName("")
                    .firstName("Michael")
                    .build();

    final private Person P2 =
            Person.builder()
                    .lastName("")
                    .firstName("Michael")
                    .build();

    @Test
    @DisplayName("Comparison test")
    void basic(){
        assertEquals(P1,P2); // have the same content
        assertNotSame(P1,P2); // aren't the same object
    }

}
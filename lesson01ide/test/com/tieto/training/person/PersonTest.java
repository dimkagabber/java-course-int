package com.tieto.training.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("Comparison test")
    void basic(){
        final Person p1 = Person.builder()
                .firstName("Stefan")
                .lastName("Muller")
                .address(Address.builder()
                    .city("Regensburg")
                    .street("Im Gevebepark")
                    .build()
                )
                .gender(Gender.MAN)
                .highSkilled(true)
                .build();

        final Person p2 = Person.builder()
                .firstName("Stefan")
                .lastName("Muller")
                .address(Address.builder()
                        .city("Regensburg")
                        .street("Im Gevebepark")
                        .build()
                )
                .gender(Gender.MAN)
                .highSkilled(true)
                .build();

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        assertEquals(p1,p2); // have the same content
        assertNotSame(p1,p2); // aren't the same object

    }

}
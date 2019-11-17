package com.tieto.training.controller;

import com.tieto.training.controller.domain.Person;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PersonSevice {
    final static Map<String, Person> PERSONS = Map.of(
            "10", Person.builder().id("10").firstName("Test1F").secondName("Test1S").build(),
            "20", Person.builder().id("20").firstName("Test2F").secondName("Test2S").build()
    );

    public Person getPerson(String personId) {
        if (personId == null){
            return null;
        }
        return PERSONS.get(personId);
    }

}

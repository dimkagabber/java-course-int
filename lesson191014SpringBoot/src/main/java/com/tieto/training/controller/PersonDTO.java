package com.tieto.training.controller;

import com.tieto.training.controller.domain.Person;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PersonDTO {
    String id;
    String name;

    public PersonDTO map(Person person){
        id = person.getId();
        name = person.getFirstName() + ", " + person.getSecondName();
        return this;
    }
}

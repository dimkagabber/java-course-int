package com.tieto.training.controller.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Person {
    String id;
    String firstName;
    String secondName;
}

package com.tieto.training.person;

import lombok.Builder;
import lombok.Value;

import java.util.Objects;

@Value
@Builder
public class Person implements Comparable<Person> {

    private final String firstName;
    private final String lastName;
    private final Address address;
    private final Gender gender;
    private final boolean highSkilled;

    @Override
    public int compareTo(Person o) {
        if (this == o) {
            return 0;
        }
        int comparisonResult = compare(this.lastName, o.getLastName());
        if (comparisonResult == 0) {
            comparisonResult = compare(this.firstName, o.getFirstName());
        }
        return comparisonResult;
    }

    private int compare(String s1, String s2) {
        //special cases
        if (s1 == s2) {
            return 0;
        }
        if (s1 == null) {
            return +1;
        }
        if (s2 == null) {
            return -1;
        }
        //put here to allow following special prio comparison
        if (s1.isEmpty() && s2.isEmpty()) {
            return 0;
        }
        if (s1.isEmpty()) {
            return +1;
        }
        if (s2.isEmpty()) {
            return -1;
        }
        //normal comparison
        return s1.compareTo(s2);
    }

}
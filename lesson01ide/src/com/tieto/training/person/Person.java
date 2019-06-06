package com.tieto.training.person;

import java.util.Objects;

public class Person {
    private final String firstName;
    private final String lastName;
    private final Address address;
    private final Gender gender;
    private final boolean highSkilled;

    public static Builder builder() {
        return new Builder();
    }

    public Person(Builder builder){
        this.firstName   = builder.firstName;
        this.lastName    = builder.lastName;
        this.gender      = builder.gender;
        this.highSkilled = builder.highSkilled;
        this.address     = builder.address;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private Address address;
        private Gender gender;
        private boolean highSkilled;

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(final Address address) {
            this.address = address;
            return this;
        }

        public Builder gender(final Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder highSkilled(final boolean highSkilled) {
            this.highSkilled = highSkilled;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Person person = (Person) o;
        return highSkilled == person.highSkilled &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(address, person.address) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, gender, highSkilled);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", gender=" + gender +
                ", highSkilled=" + highSkilled +
                '}';
    }
}
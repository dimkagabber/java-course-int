package com.tieto.training.person;

import java.util.Objects;

public class Person {
    private final String firstName;
    private final String lastName;
    private final Address address;
    private final Gender gender;
    private final boolean highSkilled;

    public Person(Builder builder) {
        this.firstName = builder.firstname;
        this.lastName = builder.lastname;
        this.address = builder.address;
        this.gender = builder.gender;
        this.highSkilled = builder.highskilled;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isHighSkilled() {
        return highSkilled;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private Address address;
        private Gender gender;
        private boolean highskilled;

        public Builder firstname(final String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(final String lastname) {
            this.lastname = lastname;
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

        public Builder highskilled(final boolean highskilled) {
            this.highskilled = highskilled;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

}

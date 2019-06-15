package com.tieto.training.person;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Person implements Comparable<Person> {
    final static int FIRST_BIGGER = 1;
    final static int EQUAL = 0;
    final static int SECOND_BIGGER = -1;

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

    @Override
    public int compareTo(@NotNull Person o) {
        if(this == o){
            return 0;
        }

        if (this.lastName.compareTo("") == 0 || o.getLastName().compareTo("") == 0) {
            if(this.lastName.compareTo(o.getLastName())== 0) {
                if (this.firstName.compareTo("") == 0 || o.getFirstName().compareTo("") == 0) {
                    if(this.firstName.compareTo(o.getFirstName()) == 0) {
                        return 0;
                    }
                    if (this.firstName.compareTo("") == 0 ){
                        return +1;
                    }
                    if (o.getFirstName().compareTo("") == 0 ){
                        return -1;
                    }
                }
                return this.firstName.compareTo(o.getFirstName());
            }
            if (this.lastName.compareTo("") == 0 ){
                return +1;
            }
            if (o.lastName.compareTo("") == 0 ){
                return -1;
            }
        }

        int comparisonResult = this.lastName.compareTo(o.getLastName());
        if(comparisonResult == 0){
            comparisonResult = this.firstName.compareTo(o.getFirstName());
        }
        return comparisonResult;
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

        public Person buildEmpty() {
            return Person.builder()
                    .firstName("").lastName("").gender(Gender.EMPTY).highSkilled(false)
                    .address(Address.builder().street("").city("").build())
                    .build();
        }
    }
}
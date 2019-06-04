package com.tieto.training.person;

import java.util.Objects;

public class Address {
    private final String city;
    private final String street;

    public String getCity() {
        return city;
    }

    public String getSteet() {
        return street;
    }

    public Address(Builder builder) {
        this.city = builder.city;
        this.street = builder.street;
    }


    public static Builder builder(){
        return new Builder();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }
    @Override
    public int hashCode() {
        return Objects.hash(city, street);
    }
    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public static class Builder {
        private String city;
        private String street;

        public Builder city(final String city) {
            this.city = city;
            return this;
        }

        public Builder street(final String street) {
            this.street = street;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}



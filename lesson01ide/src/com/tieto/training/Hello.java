package com.tieto.training;

public class Hello {
    public static void main(String[] args) {
        Cat feline1 = new Cat("Kocka");
        Cat feline2 = new Cat("Kocour");

        System.out.println(feline1.getName() + " says "+ feline1.makeSound());
        System.out.println(feline2.getName() + " says "+ feline2.makeSound());
    }
}

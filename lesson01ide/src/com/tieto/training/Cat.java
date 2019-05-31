package com.tieto.training;

public class Cat {
    final private String name;
    private String sound = "\"Purr\"";

    public String getName() {
        return name;
    }

    public Cat(String name){
        this.name = name;
    }

    public String makeSound(){
        return sound;
    }
}

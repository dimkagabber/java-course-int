package com.tieto.practice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.tieto.training.person.*;

@Disabled
class InstantiateSingleGenericElementTest {

    @Test
    void getInstanceOfGenericParameter() {
        InstantiateSingleGenericElement element = new InstantiateSingleGenericElement();
        //Address address = Address.builder().build();
        //Address result = element.getInstanceOfGenericParameter(address);
        String string = "empty";
        String result = element.getInstanceOfGenericParameter(string);
        System.out.println(result);
    }
}
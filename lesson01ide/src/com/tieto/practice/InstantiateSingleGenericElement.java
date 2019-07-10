package com.tieto.practice;

import java.lang.reflect.InvocationTargetException;

public class InstantiateSingleGenericElement {
    <T> T getInstanceOfGenericParameter(T input) {

        try {
            T newInstance;
            newInstance = (T) input.getClass().getDeclaredConstructor().newInstance();
            return newInstance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

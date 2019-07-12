package com.tieto.practice;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class ShuffleTest {

    @Test
    void outputTest()
    {
        String[] input = {"BA", "ABC", "CDE", "ACE", "", " "};
        List<String> list = new ArrayList<String>();
        for (String a : input) {
            list.add(a);
        }
        System.out.println(list);
        Collections.shuffle(list, new Random());
        System.out.println(list);
    }
}
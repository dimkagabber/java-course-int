package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private List<String> mylist;

    private final String S0 = "Value 1";
    private final String S1 = "Value 2";
    private final String S2 = "Value 3";
    private final String S3 = "Value 4";
    private final String S4 = "Value 5";


    @BeforeEach
    void init(){
        mylist = new MyArrayList<>();
        mylist.add(S0);
        mylist.add(S1);
        mylist.add(S2);
        mylist.add(S3);
    }

    @Test
    void equalsWhenNullElements() {
        List<String> list1 = new MyArrayList<>();
        List<String> list2 = new MyArrayList<>();
        list1.add(S0);
        list1.add(null);
        list1.add(S2);
        list1.add(S3);

        list2.add(S0);
        list2.add(null);
        list2.add(S2);
        list2.add(S3);

        assertTrue(list1.equals(list2));
    }

    @Test
    void equalsWhenNullElementsAndDifferent() {
        List<String> list1 = new MyArrayList<>();
        List<String> list2 = new MyArrayList<>();
        list1.add(S0);
        list1.add(null);
        list1.add(S2);
        list1.add(S3);

        list2.add(S0);
        list2.add(S1);
        list2.add(S2);
        list2.add(S3);

        assertFalse(list1.equals(list2));
    }

    @Test
    void equalsWhenNullElementsAndDifferentSecondCase() {
        List<String> list1 = new MyArrayList<>();
        List<String> list2 = new MyArrayList<>();
        list1.add(S0);
        list1.add(S1);
        list1.add(S2);
        list1.add(S3);

        list2.add(S0);
        list2.add(null);
        list2.add(S2);
        list2.add(S3);

        assertFalse(list1.equals(list2));
    }

    @Test
    void equalsBasicTrue() {
        List<String> list = new MyArrayList<>();
        list.add(S0);
        list.add(S1);
        list.add(S2);
        list.add(S3);
        assertTrue(mylist.equals(list));
    }


    @Test
    void MyArrayListEqualsDifferentElementsTest() {
        List<String> list = new MyArrayList<>();
        list.add(S0);
        list.add(S2);
        list.add(S1);
        list.add(S3);

        assertFalse(mylist.equals(list));
    }

    @Test
    void MyArrayListEqualsLessElementsTest() {
        List<String> list = new MyArrayList<>();
        list.add(S0);
        list.add(S1);

        assertFalse(mylist.equals(list));
    }

    @Test
    void MyArrayListEqualsNotList() {
        Queue<String> queue = new PriorityQueue<>();
        queue.add(S0);
        queue.add(S1);
        queue.add(S2);
        queue.add(S3);

        assertFalse(mylist.equals(queue));
    }

}
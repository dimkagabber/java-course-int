package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    private List<String> list;

    private final String S0 = "Value 1";
    private final String S1 = "Value 2";
    private final String S2 = "Value 3";

    @BeforeEach
    void init(){
        list = new ArrayList<String>();
    }

    @Test
    void ListBasicTest() {

        assertTrue(list.isEmpty());
        assertEquals(0,list.size());

        list.add(S0);
        assertFalse(list.isEmpty());
        assertEquals(1,list.size());

        list.add(S1);
        assertFalse(list.isEmpty());
        assertEquals(2,list.size());

        list.add(S0);
        assertFalse(list.isEmpty());
        assertEquals(3,list.size());

        assertEquals(S0,list.get(0));
        assertEquals(S1,list.get(1));
        assertEquals(S0,list.get(2));

        //assertEquals()
    }

}

package com.tieto.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListFilterTest {

    private ListFilter filter;

    final String S0 = "Shirt";
    final String S1 = "Medium";
    final String S2 = "VeryLong";
    final String S3 = "TheLongest";

    @BeforeEach
    void init() {
        filter = new ListFilter();
    }

    @Test
    void filterBasic() {
        List list = new ArrayList();
        list.add(S0);
        list.add(S1);
        list.add(S2);
        list.add(S3);

        List expected = new ArrayList();
        expected.add(S2);
        final boolean add = expected.add(S3);

        Condition condition = new LengthCondition(6);

        assertEquals(expected,filter.filter(list,condition));
        //assertEquals(expected,filter.filter(list, (Condition<String>) Object -> false));
    }
}

class LengthCondition implements Condition<String> {
    private int length;

    public LengthCondition(final int i) {
        this.length = i;
    }

    @Override
    public boolean isValid(final String object) {
        if(object.length() > this.length){
            return true;
        }
        return false;
    }
}
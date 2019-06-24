package com.tieto.training;

import java.util.Comparator;

public class StringComparatorEmptyHasPriority implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1 == o2) {
            return 0;
        }
        if(o1 == null) {
            return +1;
        }
        if(o1.compareTo("") == 0) {
            return +1;
        }
        return o1.compareTo(o2);
    }
}

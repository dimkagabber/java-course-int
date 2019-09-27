package com.tieto.training;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListFilter {

    public <E> List<E> filter(final List<E> list, Condition<E> condition){
        Iterator<E> itr = list.iterator();
        List<E> result = new ArrayList<>();
        Object element = new Object();

        while(itr.hasNext()){
            element = itr.next();
            if(condition.isValid((E) element)){
                result.add((E) element);
            };
        }
        return result;
    }
}

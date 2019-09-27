package com.tieto.training;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MyArrayList<E> extends ArrayList<E> {

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof List)) {
            return false;
        }

        Iterator<E> itr1 = this.iterator();
        Iterator<E> itr2 = ((List) o).iterator();

        /*while(itr1.hasNext()) {
            Object element1 =  itr1.next();
            if(itr2.hasNext()){
                Object element2 =  itr2.next();
                if(element1 != null) {
                    if (element1.equals(element2)) {
                        continue;
                    }
                }
                if(element1 == element2) {
                    continue;
                }
            }
            return false;
        }*/

        while (itr1.hasNext() && itr2.hasNext()) {
            if (!Objects.equals(itr1.next(), itr2.next())) {
                return false;
            }
        }

        return !itr1.hasNext() && !itr2.hasNext();
    }
}

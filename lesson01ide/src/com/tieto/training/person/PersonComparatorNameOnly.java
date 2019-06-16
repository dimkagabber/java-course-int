package com.tieto.training.person;
import java.util.Comparator;

public class PersonComparatorNameOnly implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }

        return o1.compareTo(o2);
    }
}
